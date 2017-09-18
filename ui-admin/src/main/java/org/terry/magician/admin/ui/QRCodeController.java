package org.terry.magician.admin.ui;

import com.google.zxing.WriterException;
import org.terry.magician.common.util.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Terry
 */
@Controller
@RequestMapping("qr")
public class QRCodeController {

    @Autowired
    QRCodeService qrCodeService;

    @RequestMapping("{format}")
    public void qrCode(HttpServletResponse response,
                       @RequestParam(value = "content", required = false) String content,
                       @RequestParam(value = "size", required = false, defaultValue = "900") Integer size,
                       @PathVariable(value = "format", required = false) String format)
            throws IOException, WriterException {
        qrCodeService.generate(response.getOutputStream(), content, size, format);
    }

}
