package challenge;

import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/service")
public class service {
	
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		@Path("/implementation1/{data1}")
		public String imp1(@PathParam("data1") String a) {	
			//创建一个新的数组放入不重复的字母
			ArrayList<Character> norepeat = new ArrayList<Character>();
			StringBuilder result = new StringBuilder();

			for(int i=0; i<a.length()-1; i++)
			{
				//不重复就放进去
				if(a.charAt(i) != a.charAt(i+1)) {
					norepeat.add(a.charAt(i));
				}
			}
			for (Character character : norepeat)
			{
				//把数组转成字符串
				result.append(character);
			}
			//加上最后一位字母
			String finalresult = ""+result;
			char fi = a.charAt(a.length()-1);
			
			finalresult += String.valueOf(fi);
			return finalresult;		
		}
		
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		@Path("/implementation2/{data2}")
		public String imp2(@PathParam("data2") String a) {	
			//设定最大值
			
			int max = 0;
			int cummu = 1;
			for(int i=0; i<a.length()-1;i++) {
				if(a.charAt(i)==a.charAt(i+1)) {
					
					//把每一位跟右边一位作比较，一样的话累计+1
					cummu+=1;
					//把最后一位累计的跟最大值作比较
					if((i+1)==a.length()-1)
					{
						if(cummu>max) {
							max = cummu;
						}
					}
				}
				else {
					//遇到不一样的block就把累计数跟最大值作比较
					if(cummu>max) {
						max = cummu;
					}
					cummu = 1;
				}
			}
			return String.valueOf(max);
		}
		
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		@Path("/implementation3/{data3}")
		public String imp3(@PathParam("data3") String a) {	
			String[] list = new String[a.length()];
			//把字符串存进list
			for(int i=0; i<a.length();i++)
			{
				list[i] = String.valueOf(a.charAt(i));
			}
			//进行不区分大小写的排序
			Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
			String result="";
			for(int i=0; i<list.length; i++) {
				result = result.concat(list[i]);
			}
			
			return result;
		}

}
