package br.com.stholen;

import java.util.stream.Collectors;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.stholen.dto.MensagemErroDto;
import br.com.stholen.exception.BusinessException;

@Provider
public class BusinnesExceptionMapper implements ExceptionMapper<BusinessException> {
	public Response toResponse (BusinessException e) {
	return Response
            .status(Response.Status.BAD_REQUEST)
            .entity( MensagemErroDto.build(e.getMensagens()))                    
            .build();
	}
}
