package com.hanfak.greedydb.infrastructure.entrypoints.rest;

import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestServletTest {

    private final HttpServletResponse response = mock(HttpServletResponse.class);
    private final PrintWriter printWriter = mock(PrintWriter.class);

    @Test
    public void returnsA200AndHello() throws IOException {
        when(response.getWriter()).thenReturn(printWriter);
        when(printWriter.append(any())).thenReturn(printWriter);

        new TestServlet().doGet(null, response);

        verify(response).setStatus(200);
        verify(printWriter).write("hello");
    }
}