package hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class InputCounties {


	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path counties = new Path("/user/train/counties");
		if(!fs.exists(counties)){
			// create hdfs path if not exists
			fs.mkdirs(counties);
		}
		for (int i=1; i<=4; i++){
			String filename = "counties_" + i + ".csv";
			Path localSrc = new Path ("../counties/" + filename);
			Path dest = new Path ("/user/train/counties/" + filename);
			System.out.println("copy " + localSrc + " to " + dest);
			fs.copyFromLocalFile(localSrc, dest);
		}
	}

}
