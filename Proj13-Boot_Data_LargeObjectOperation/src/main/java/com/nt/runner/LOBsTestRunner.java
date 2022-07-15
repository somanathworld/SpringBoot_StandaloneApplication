package com.nt.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMatrimonyServiceMgmt;

@Component
public class LOBsTestRunner implements CommandLineRunner{

	@Autowired
	private IMatrimonyServiceMgmt service;
	
	@Override
	public void run(String... args) throws Exception {

//		InputStream is = new FileInputStream("C:\\Users\\DELL\\Documents\\somanath mishra\\pht2.jpg");
//		byte[] photoData = new byte[is.available()];
//		photoData = is.readAllBytes();
//		
//		File file = new File("C:\\Users\\DELL\\Documents\\lappy pass.pdf");
//		Reader reader = new FileReader(file);
//		char[] bioContent = new char[(int)file.length()];
//		reader.read(bioContent);
//		
//		MarriageSeeker seeker = new MarriageSeeker("Raja", "Hyd", photoData, LocalDateTime.now(), bioContent,true);
//		
//		System.out.println(service.registerMarriageSeeker(seeker));
		
		System.out.println("=========================");
		Optional<MarriageSeeker> opt = service.searchSeekerById(6L);
		
		if(opt.isPresent()) {
			MarriageSeeker seeker = opt.get();
			System.out.println(seeker.getId()+" "+seeker.getName()+" "+seeker.getAddrs()+" "+seeker.getDob()+" "+seeker.getIndian());
			OutputStream os = new FileOutputStream("retrieve_photo_"+seeker.getId()+".jpg");
			os.write(seeker.getPhoto());
			os.flush();
			Writer writer = new FileWriter("retrieve_doc_"+seeker.getId()+".pdf");
			writer.write(seeker.getBiodata());
			writer.flush();
			os.close();
			writer.close();
			System.out.println("LOBs retrieved.");
		}else {
			System.out.println("Record not found.");
		}
		
	}
	
}
