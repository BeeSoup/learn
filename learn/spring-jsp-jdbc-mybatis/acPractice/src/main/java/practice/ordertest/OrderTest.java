package practice.ordertest;

/**
 * 			Map<String, ViewResolver> matchingBeans =
 * 					BeanFactoryUtils.beansOfTypeIncludingAncestors(context, ViewResolver.class, true, false);
 * 			if (!matchingBeans.isEmpty()) {
 * 				this.viewResolvers = new ArrayList<>(matchingBeans.values());
 * 				// We keep ViewResolvers in sorted order.
 * 				AnnotationAwareOrderComparator.sort(this.viewResolvers);
 *                        @Configuration(proxyBeanMethods = false)
 * @ConditionalOnWebApplication(type = Type.SERVLET)
 * @ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })
 * @ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
 * @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
 * @AutoConfigureAfter({ DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class,
 * 		ValidationAutoConfiguration.class })
 */
public class OrderTest {
}
