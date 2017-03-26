package cn.net.fusen.ssm.aop;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import cn.net.fusen.ssm.utils.CommonUtils;
import cn.net.fusen.ssm.wx.utils.DynamicDataSource;

public class AopTestAspect {

	// 前置通知
	public void qianZhiTZ(JoinPoint jp) {
		System.out.println("被代理方法名字：" + jp.getSignature().getName());
		System.out.println("被代理方法参数：" + jp.getArgs());
		System.out.println("被代理对象：" + jp.getTarget());
		System.out.println("现在调用的是权限验证");
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);
	}

	public void log(JoinPoint jp, Object rvt) {
		System.out.println("被代理方法名字：" + jp.getSignature().getName());
		System.out.println("被代理方法参数：" + jp.getArgs());
		System.out.println("被代理对象：" + jp.getTarget());
		System.out.println("被代理对象的返回值" + rvt);
		System.out.println("现在调用的是日志管理");
	}

	// 环绕通知
	public Object testAround(ProceedingJoinPoint pjp) throws Throwable {
		
		//((MethodSignature)pjp.getSignature()).getReturnType();
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_B);

		// 得到业务方法的参数
		Object[] args = pjp.getArgs();
		// 被代理对象的业务方法
		int rnd = CommonUtils.myRnd(0, 100);
		if (rnd%2==0) {//如果是双数
			return pjp.proceed(args);
		}else {
			HttpServletResponse response = null;
			for (int i = 0; i < args.length; i++) {
				if (args[i] instanceof HttpServletResponse) {
					response = (HttpServletResponse)args[i];//.getWriter().print("are you ok?");
					break;
				}
			}
			if(response!=null){
				response.getWriter().print("are you ok?");
			}
			return null;
		}
	}
	
	/*public static void main(String[] args) {
		System.out.println(CommonUtils.myRnd(0, 100));
		
	}*/

	public void release() {
		System.out.println("资源已经被释放！");
	}

}
