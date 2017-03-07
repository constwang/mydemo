package compress;

import net.jpountz.lz4.LZ4BlockInputStream;
import net.jpountz.lz4.LZ4BlockOutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by wa on 2017/1/13.
 */
public class CompressFile {

    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder value = new StringBuilder() ;
        for (int i = 0; i < 100; i++) {
            value.append("java gzip 压缩测试");
        }
        byte[] data=value.toString().getBytes();
        LZ4Factory factory=LZ4Factory.fastestInstance();
        LZ4Compressor compressor=factory.fastCompressor();
        long start=System.currentTimeMillis();
        byte[] compressedData=compressor.compress(data);
        long end=System.currentTimeMillis();
        System.out.println("before: "+data.length);
        System.out.println("after: "+compressedData.length);
        System.out.println("time used: "+(end-start));
        //System.out.println(new String(compressedData));
    }
}
