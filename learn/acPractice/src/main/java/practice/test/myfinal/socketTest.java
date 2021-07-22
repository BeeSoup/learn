/*
 * 软件版权: 恒生电子股份有限公司
 * 修改记录:
 * 修改日期     修改人员  修改说明
 * ========    =======  ============================================
 * 2021/6/25  zhangyu30939  新增
 * ========    =======  ============================================
 */
package practice.test.myfinal;


import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 功能说明:
 *
 * @author zhangyu30939
 * @since 2021-06-25
 */
public class socketTest {

    private static final Logger log = LoggerFactory.getLogger(socketTest.class);

    /**
     * 发送socket请求
     *
     * @param clientIp
     * @param clientPort
     * @param msg
     * @return
     */
    private static synchronized String tcpPost(String clientIp, String clientPort, String msg) {
        String rs = "";

        if (clientIp == null || "".equals(clientIp) || clientPort == null || "".equals(clientPort)) {
            return null;
        }

        int clientPortInt = Integer.parseInt(clientPort);


        Socket s = null;
        OutputStream out = null;
        InputStream in = null;
        try {
            s = new Socket(clientIp, clientPortInt);
            s.setTcpNoDelay(true);
            //s.setSoTimeout(1*1000);
            s.setSendBufferSize(4096);
            s.setKeepAlive(true);
            out = s.getOutputStream();
            in = s.getInputStream();

            //准备报文msg


            out.write(msg.getBytes("GBK"));
            out.flush();

            byte[] rsByte = readStream(in);


            if (rsByte != null) {
                rs = new String(rsByte, "GBK");
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (out != null) {
                    out.close();
                    out = null;
                }
                if (in != null) {
                    in.close();
                    in = null;
                }
                if (s != null) {
                    s.close();
                    s = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info(rs);
        return rs;

    }

    /**
     * 读取输入流
     *
     * @param in
     * @return
     */
    private static byte[] readStream(InputStream in) {
        if (in == null) {
            return null;
        }

        byte[] b = null;
        ByteArrayOutputStream outSteam = null;
        try {
            byte[] buffer = new byte[1024];
            outSteam = new ByteArrayOutputStream();

            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }

            b = outSteam.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outSteam != null) {
                    outSteam.close();
                    outSteam = null;
                }
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
//        String msg="0000003122<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:in=\"http://www.whrcbank.com/common/header/in\">\n" +
//                "\t<soap:Header>\n" +
//                "\t\t<in:sysHeader>\n" +
//                "\t\t\t<in:msgId>0147202011171419410010017</in:msgId>\n" +
//                "\t\t\t<in:msgDate>2020-11-17</in:msgDate>\n" +
//                "\t\t\t<in:msgTime>14:19:41.864</in:msgTime>\n" +
//                "\t\t\t<in:servCd>R20701004027</in:servCd>\n" +
//                "\t\t\t<in:operation>ChmtEsrFileInfoQry</in:operation>\n" +
//                "\t\t\t<in:sysCd>147</in:sysCd>\n" +
//                "\t\t\t<in:bizId>000</in:bizId>\n" +
//                "\t\t\t<in:bizType>1</in:bizType>\n" +
//                "\t\t\t<in:orgCd>01002</in:orgCd>\n" +
//                "\t\t\t<in:resCd/>\t\t\t\n" +
//                "\t\t\t<in:resText/>\n" +
//                "\t\t\t<in:bizResCd/>\n" +
//                "\t\t\t<in:bizResText/>\n" +
//                "\t\t\t<in:ver>110.100.111</in:ver>\n" +
//                "\t\t\t<in:authId/>\n" +
//                "\t\t\t<in:authPara/>\n" +
//                "\t\t\t<in:authContext/>\n" +
//                "\t\t\t<in:pinIndex/>\n" +
//                "\t\t\t<in:pinValue/>\n" +
//                "\t\t</in:sysHeader>\n" +
//                "\t</soap:Header>\n" +
//                "\t<soap:Body>\n" +
//                "\t\t<r19:request xmlns:r19=\"http://www.whrcbank.com/service/bd/R20701004027\">\n" +
//                "\t\t\t<r19:bizHeader>\n" +
//                "\t\t\t\t<zhgl:ReqSysCd xmlns:zhgl=\"http://www.whrcbank.com/service/hd/zhgl\">147</zhgl:ReqSysCd>\n" +
//                "\t\t\t\t<zhgl:TxnCd xmlns:zhgl=\"http://www.whrcbank.com/service/hd/zhgl\">R19001004018</zhgl:TxnCd>\n" +
//                "\t\t\t\t<zhgl:BrchNo xmlns:zhgl=\"http://www.whrcbank.com/service/hd/zhgl\">01002</zhgl:BrchNo>\n" +
//                "\t\t\t\t<zhgl:ReqDt xmlns:zhgl=\"http://www.whrcbank.com/service/hd/zhgl\">2020-11-17</zhgl:ReqDt>\n" +
//                "\t\t\t\t<zhgl:ReqTm xmlns:zhgl=\"http://www.whrcbank.com/service/hd/zhgl\">143445</zhgl:ReqTm>\n" +
//                "\t\t\t\t<zhgl:AuthTlr xmlns:zhgl=\"http://www.whrcbank.com/service/hd/zhgl\"/>\n" +
//                "\t\t\t\t<zhgl:ReqSeqNo xmlns:zhgl=\"http://www.whrcbank.com/service/hd/zhgl\">Q20010020201117000008</zhgl:ReqSeqNo>\n" +
//                "\t\t\t\t<zhgl:WhlSeqNo xmlns:zhgl=\"http://www.whrcbank.com/service/hd/zhgl\">Q20010020201117000008</zhgl:WhlSeqNo>\n" +
//                "\t\t\t\t<zhgl:TlrNo xmlns:zhgl=\"http://www.whrcbank.com/service/hd/zhgl\">200100</zhgl:TlrNo>\n" +
//                "\t\t\t\t<zhgl:VTlrNo xmlns:zhgl=\"http://www.whrcbank.com/service/hd/zhgl\"/>\n" +
//                "\t\t\t</r19:bizHeader>\n" +
//                "\t\t\t<r19:bizBody>\n" +
//                "\t\t\t\t<r19:prdCode></r19:prdCode>\n" +
//                "\t\t\t\t<r19:reportType></r19:reportType>\n" +
//                "\t\t\t\t<r19:publishDate></r19:publishDate>\t\t\t\t\n" +
//                "\t\t\t</r19:bizBody>\n" +
//                "\t\t</r19:request>\n" +
//                "\t</soap:Body>\n" +
//                "</soap:Envelope>";

        // 生成一个默认的资源文件读取流
        ResourceLoader loader = new DefaultResourceLoader();
        // 根据目标位置读取文件
        Resource resource = loader.getResource("classpath:/wh/武农商渠道请求XML定义.xml");
        // 获取文件
        File file = resource.getFile();

        // 读取文件形成输入流
        FileInputStream inputStream = new FileInputStream(file);
        // 创建一个输出流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 讲文件从输入流，传到输出流
        IOUtils.copyLarge(inputStream, outputStream);
        String msg = outputStream.toString("GBK");

        tcpPost("127.0.0.1", "7800", msg);

//        tcpPost("10.20.39.75","7800",msg);
    }
}
