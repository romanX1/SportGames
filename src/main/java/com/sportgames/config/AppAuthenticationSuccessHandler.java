//package com.sportgames.config;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Collection;
//
//@Component
//public class AppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
//
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request,
//                                        HttpServletResponse response, Authentication authentication)
//            throws IOException {
//
//        handle(request, response, authentication);
//    }
//
//    protected void handle(HttpServletRequest request,
//                          HttpServletResponse response, Authentication authentication) throws IOException {
//
//        String targetUrl = determineTargetUrl(authentication);
//        redirectStrategy.sendRedirect(request, response, targetUrl);
//    }
//
//    protected String determineTargetUrl(Authentication authentication) {
//        boolean isUser = false;
//        boolean isAdmin = false;
//
//
//        Collection<? extends GrantedAuthority> authorities
//                = authentication.getAuthorities();
//        for (GrantedAuthority grantedAuthority : authorities) {
//            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
//                isUser = true;
//                break;
//            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
//                isAdmin = true;
//                break;
//            }
//        }
//
//        if (isUser) {
//            return "/playgrounds";
//        } else if (isAdmin) {
//            return "/adminPage";
//        } else {
//            throw new IllegalStateException();
//        }
//    }
//}