import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.codec.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.omg.CORBA.portable.InputStream;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


/*
 * ��װ��GSON���������࣬�ṩ���Ͳ���
 */
class GsonUtil {
    // ��Json���ݽ�������Ӧ��ӳ�����
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        T result = gson.fromJson(jsonData, type);
        return result;
    }

    // ��Json�����������Ӧ��ӳ������б�
    public static <T> List<T> parseJsonArrayWithGson(String jsonData, Class<T> type) {
        Gson gson = new Gson();
        List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {}.getType());
        return result;
    }
    
    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
	    T[] arr = new Gson().fromJson(s, clazz);
	    return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
	}
}

class Info {
    private String title;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}



public class PythonTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		// ������
		String SpiderName = "CdutAao";
		// ����·��
		String SpiderPath = "C:\\Users\\wllkn\\Documents\\GitHub\\ScrapyPractice\\tutorial";
		// ע���ʽ��&ǰ��Ҫ^����cmd��ת��
		String url = "http://www.aao.cdut.edu.cn/aao/aao.php?sort=389^&sorid=391^&from=more^&offset=0";
		// ע���ʽ������ǰ��Ҫ����ת���\
		String xpath = "//*[@id=\\\"news_content\\\"]/table/tr[2]/td/table/tr/td";
		// ȡ��ʱ���������md5�ļ���������
		String time = Long.toString(new Date().getTime());
		String md5 = DigestUtils.md5Hex(url+xpath+time);
		
		String fileName = md5+".json";
		// ��Ҫִ�е����
		String scrapy = "scrapy crawl " + SpiderName + 
						" -a url=" + url + 
						" -a xpath=" + xpath + 
						" -o " + fileName;
		System.out.println(scrapy);
		
		// ��������
		String env = "activate python36";
		String folder = "cd " + SpiderPath;
		// ����ִ�����
		String process = "cmd /c "+ folder + "&&" + env + "&&" + scrapy;
		// ִ��
		Process pr = Runtime.getRuntime().exec(process);
		// �ȴ��첽����
		pr.waitFor();

		String encoding="UTF-8";
        File file=new File(SpiderPath + "\\" + fileName);
        // ���ǵ������ʽ���ж�ȡ
        InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;
        String allText = "";
        while((lineTxt = bufferedReader.readLine()) != null){
        	allText += lineTxt;
//            System.out.print(lineTxt);
        }
        read.close();
        file.delete();

        List<Info> infoJson = GsonUtil.stringToArray( allText, Info[].class);
        for( int i=0; i<infoJson.size(); i++){
        	System.out.println(infoJson.get(i).getTitle()+","+infoJson.get(i).getLink());
        }
        

	}

}
