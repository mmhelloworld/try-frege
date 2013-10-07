package tryfrege.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import frege.runtime.Lambda;

import tryfrege.repl.FregeReplServlet;

/**
 * Evaluates Frege code and returns the result.
 *
 */
public class FregeReplController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doPost(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		final Lambda scriptResultIO = FregeReplServlet.doPost(this, request, response);
		scriptResultIO.apply(1).result().forced();
	}

	@Override
	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException,
			IOException {
		doPost(request, response);
	}
}
