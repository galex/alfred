package alfred.weaving.internal;

import android.os.Looper;
import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;

/**
 * Created by galex on 12/1/14.
 */

@Aspect
public class Alfred {

    @Pointcut("execution(@CheckThread * *(..))")
    public void method() {}

    @Pointcut("execution(@CheckThread *.new(..))")
    public void constructor() {}

    @Around("method() || constructor()")
    public Object checkThread(ProceedingJoinPoint joinPoint) throws Throwable {

        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();

        Class<?> cls = codeSignature.getDeclaringType();
        String methodName = codeSignature.getName();

        StringBuilder builder = new StringBuilder();
        builder.append(prettyClassName(cls) + "#"+ methodName);

        if (Looper.myLooper() == Looper.getMainLooper()) builder.append(" @[MainThread]");
        else builder.append(" @[" + Thread.currentThread().getName() + "]");

        Log.v("Alfred", builder.toString());

        return joinPoint.proceed();
    }

    private static String prettyClassName(Class c){

        return c.getName().substring(c.getName().lastIndexOf(".") + 1);
    }
}
