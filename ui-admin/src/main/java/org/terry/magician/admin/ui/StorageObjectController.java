package org.terry.magician.admin.ui;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.terry.magician.common.util.JsonService;
import org.terry.magician.constant.PageConstants;
import org.terry.magician.domain.PageImplWrapper;
import org.terry.magician.domain.StorageObject;
import org.terry.magician.rpc.hystrix.HystrixOSSServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/26.
 */
@Controller
@RequestMapping("img")
public class StorageObjectController {
    @Autowired
    HystrixOSSServiceClient hystrixOSSServiceClient;
    private  static SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMDD");
    // endpoint以杭州为例，其它region请按实际情况填写
    static  String endpoint = "oss-cn-shanghai.aliyuncs.com";
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
    static String accessKeyId = "你的accessKeyId";
    static String accessKeySecret = "你的accessKeySecret";
    static String bucketName ="你的bucketName";
    private volatile static OSSClient ossClient;
    public StorageObjectController() {
        if (ossClient == null) {
            synchronized (this) {
                if (ossClient == null) {
                    ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
                }
            }
        }
    }

    @Autowired
    JsonService jsonService;
    @RequestMapping("/list")
    public String list(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = PageConstants.DEFAULT_PAGE_NUMBER) Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = PageConstants.DEFAULT_PAGE_SIZE) Integer size,
                       @RequestParam(value = "sort", required = false) List<String> sort) {
        final PageImplWrapper<StorageObject> pageList = hystrixOSSServiceClient.getPage(page, size, sort);
        model.addAttribute("page", pageList);
        return "img/imgList";
    }
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form(Model model, @RequestParam(value = "id", required = false) String id) {
        StorageObject storageObject = null;
        if (StringUtils.isEmpty(id)) {
            storageObject = new StorageObject();
        } else {
            storageObject = hystrixOSSServiceClient.getById(id);
        }
        model.addAttribute("entity", storageObject);
        return "img/imgForm";
    }
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public Object testUploadFile(@RequestParam("imgFile")MultipartFile file)  {
        if(!file.isEmpty()){
            try {
              /*
               * 这段代码执行完毕之后，图片上传到了工程的跟路径；
               * 大家自己扩散下思维，如果我们想把图片上传到 d:/files大家是否能实现呢？
               * 等等;
               * 这里只是简单一个例子,请自行参考，融入到实际中可能需要大家自己做一些思考，比如：
               * 1、文件路径；
               * 2、文件名；
               * 3、文件格式;
               * 4、文件大小的限制;
               */
              /*  BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();*/
                ObjectMetadata meta = new ObjectMetadata();
                meta.setContentLength(file.getSize());
                String originalFilename = file.getOriginalFilename();
                String guessContentType=null;
                int lastIndexOf = originalFilename.lastIndexOf(".");
                if (lastIndexOf != -1){
                    guessContentType="image/"+originalFilename.substring(lastIndexOf+1);
                    meta.setContentType(guessContentType);
                }else {
                     guessContentType = URLConnection.guessContentTypeFromStream(file.getInputStream());
                     meta.setContentType(guessContentType);
                }
                String data=sdf.format(new Date());
                UUID uuid = UUID.randomUUID();
                String fileId = data+"/"+uuid.toString();
                PutObjectRequest putObjectRequest=new PutObjectRequest(bucketName,fileId,file.getInputStream());//上传文件
                putObjectRequest.setMetadata(meta);
                ossClient.putObject(putObjectRequest);//上传图片

                StorageObject storageObject=new StorageObject();
                storageObject.setCreateTime(new Date());
                StringBuffer url=new StringBuffer("http://");
                url.append(bucketName).append(".").append(endpoint).append("/").append(fileId);
                storageObject.setUrl(url.toString());
                hystrixOSSServiceClient.save(jsonService.toJson(storageObject));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return"上传失败,"+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return"上传失败,"+e.getMessage();
            }
            return"上传成功";
        }else{
            return"上传失败，因为文件是空的.";
        }
    }

}
