package cn.net.fusen.ssm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import cn.net.fusen.ssm.wx.utils.DynamicDataSource;

@Component
public class DataSourceSwitchAspect {
	// 前置通知
	public void qianZhiTZ(JoinPoint jp) {
		/*
		 * System.out.println("被代理方法名字："+jp.getSignature().getName());
		 * System.out.println("被代理方法参数："+jp.getArgs());
		 * System.out.println("被代理对象："+jp.getTarget());
		 * System.out.println("现在调用的是权限验证");
		 */
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);
	}

	// 环绕通知
	public Object around(ProceedingJoinPoint pjp) throws Throwable {

		// ((MethodSignature)pjp.getSignature()).getReturnType();
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);
		return pjp.proceed(pjp.getArgs());

		/*// 得到业务方法的参数
		Object[] args = pjp.getArgs();
		// 被代理对象的业务方法
		int rnd = CommonUtils.myRnd(0, 100);
		if (rnd % 2 == 0) {// 如果是双数
			return pjp.proceed(args);
		} else {
			HttpServletResponse response = null;
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof HttpServletResponse) {
					response = (HttpServletResponse) args[i];// .getWriter().print("are you ok?");
					break;
				}
			}
			if (response != null) {
				response.getWriter().print("are you ok?");
			}
			return null;
		}*/
	}
}
