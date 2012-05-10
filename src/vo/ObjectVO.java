package vo;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class ObjectVO {
	public boolean isEquals(ObjectVO vo) throws Exception {
		Class self = this.getClass();
		Class other = vo.getClass();
		Object params[] = {};

		if (!self.getName().equals(other.getName())) {
			return false;
		}

		Pattern p = Pattern.compile("^get");
		Matcher m = null;
		for (Method mtd : self.getDeclaredMethods()) {
			m = p.matcher(mtd.getName());
			if (m.find()) {
				Object srcIvk = mtd.invoke(this, params);
				Object dstIvk = mtd.invoke(vo, params);
				if (mtd.getReturnType().isPrimitive()) {
					if (srcIvk != dstIvk) {
						return false;
					}
				} else {
					try {
						mtd.getReturnType().asSubclass(ObjectVO.class);
						if (srcIvk != null
								&& dstIvk != null
								&& !((ObjectVO) srcIvk)
										.isEquals((ObjectVO) dstIvk)) {
							return false;
						}
					} catch (ClassCastException e) {
						if (srcIvk != null && dstIvk != null
								&& !srcIvk.equals(srcIvk)) {

							return false;
						}
					}
				}
			}
		}
		return true;
	}
}
