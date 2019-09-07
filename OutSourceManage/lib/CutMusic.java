import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File; import java.io.FileInputStream; import java.io.FileNotFoundException; 
import java.io.FileOutputStream; import java.io.IOException; import java.io.InputStream; /**  * 音乐剪切和拼接（音乐串烧）  * @author   *  */
public class CutMusic {  
	public static void main(String[] args) {   //f1,f2分别为需要剪切的歌曲路径  
	File f1 = new File("E:\\misc\\1.mp3");  
	File f2 = new File("E:\\misc\\2.mp3");   //f为合并的歌曲  
	File f = new File("E:\\misc\\13.mp3");   
	
	
	
	cut1(f1,f2,f); 
	
	} 
public static void cut1(File f1,File f2,File f){ 
	BufferedInputStream bis1 = null;   BufferedInputStream bis2 = null; 
	BufferedOutputStream bos = null;   //第一首歌剪切部分起始字节  
	int start1 = 0;//128kbps（比特率）*58s*1024/8=2375680 比特率可以查看音频属性获知   
	int end1 = 128*10*1024/8;   
	//320kbps*120s*1024/8=4915200     
	//第二首歌剪切部分起始字节，计算方式同上 
	int start2 = 0;  
	int end2 = 0;     
	int tatol1 = 0;   int tatol2 = 0;   try {   
		//两个输入流   
		bis1 = new BufferedInputStream(new FileInputStream(f1));  
		bis2 = new BufferedInputStream(new FileInputStream(f2)); 
		//缓冲字节输出流（true表示可以在流的后面追加数据，而不是覆盖！！） 
		bos = new BufferedOutputStream(new FileOutputStream(f,true));         //第一首歌剪切、写入  
		byte[] b1= new byte[512];    int len1 = 0;
		while((len1 = bis1.read(b1))!=-1){    
			tatol1+=len1;   //累积tatol   
			if(tatol1<start1 ){  //tatol小于起始值则跳出本次循环  
				continue;     } 
			bos.write(b1);   //写入的都是在我们预先指定的字节范围之内    
			if(tatol1>=end1 ){ 
				//当tatol的值超过预先设定的范围，则立刻刷新bos流对象，并结束循环
				bos.flush();      break;     }       
			}    System.out.println("第一首歌剪切完成！");        
			//第二首歌剪切、写入，原理同上   
			byte[] b2= new byte[512];  
			int len2 = 0;   
			while((len2 = bis2.read(b2))!=-1){     
				tatol2 += len2;     
				if(tatol2 < start2){   
					continue;  
				}     bos.write(b2);    
				if(tatol2>=end2){     
					bos.flush();    
				break;     }         
				}   
			System.out.println("第二首歌剪切完成！"); 
				} catch (IOException e) {    // TODO Auto-generated catch block   
					e.printStackTrace();   }finally{   
						try {//切记要关闭流！！
						if(bis1!=null) bis1.close();    
						if(bis2!=null) bis2.close();  
						if(bos!=null) bos.close();   
						} catch (IOException e) {    
							// TODO Auto-generated catch block  
							e.printStackTrace(); 
							}   }  }   }
		 
 