package br.com.stholen.interception;

import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.ejb.EJBException;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolationException;

@Interceptor
//anotacao para que este interceptor rode primeiro
@Priority(1)
@br.com.stholen.interception.Logger
public class LoggerInterceptor {
	
	@AroundInvoke
	public Object treatException(InvocationContext context) throws Exception {
		
		Logger logger = Logger.getLogger(context.getTarget().getClass().getName());
		
		try {
			return context.proceed();
		} catch ( Exception e) {
			if(e.getCause() instanceof ConstraintViolationException) {
				logger.info(e.getMessage());
			}
			else {
				logger.severe(e.getMessage());
			}
			
			//temos que lançar uma exeçao para cima senao o ExceptionMapper(classe com mensagens customizadas
			//para excessao) nao ira pegar estas mensagens.
			throw e;
		}
	}
}
