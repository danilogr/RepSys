package vo;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class ObjectVO {
	public boolean equals(ObjectVO vo) throws Exception {
		Class self = this.getClass();
		Class other = vo.getClass();
		Object params[] = {};
		
		if(!self.getName().equals(other.getName())) {
			return false;
		}
		
		Pattern p = Pattern.compile("^get");
		Matcher m = null;
		for(Method mtd : self.getDeclaredMethods()) {
			m = p.matcher(mtd.getName());
			if(m.find()) {
				try {
					if(mtd.getReturnType().isPrimitive()) {
						if(mtd.invoke(this, params) != mtd.invoke(vo, params)) {
							return false;
						}
					} else if(mtd.getReturnType().is) { 
					} else {
						if(!mtd.invoke(this, params).equals(mtd.invoke(vo, params))) {
							System.out.println(mtd.invoke(this, params));
							System.out.println(mtd.invoke(vo, params));
							return false;
						}
					}
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return true;
	}
}
