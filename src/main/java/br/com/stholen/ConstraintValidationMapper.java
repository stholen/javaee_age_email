package br.com.stholen;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.stholen.dto.MensagemErroDto;

/*Classe contruida extendo uma lcasse do JAX-RS para poder capturar excessoes e poder retornar
 * da maneira que acharmos melhor*/
@Provider
public class ConstraintValidationMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException e) {
	    return Response
	            .status(Response.Status.BAD_REQUEST)
	            .entity( MensagemErroDto.build(
	                    e.getConstraintViolations()
	                        .stream()
	                        .map(constraintViolation -> constraintViolation.getMessage())
	                        .collect(Collectors.toList())))
	            .build();
	}

}
