package com.your.time.util;
public class YourTimeRestURIConstants {

	public static class UsersWS{
		public static final String WS_USER_SIGN_UP = "/users/self/register";
		public static final String WS_USER_ADD = "/users/register";
		public static final String WS_USER_AUTHENDICATE = "/users/authendicate";
		public static final String WS_USER_HOME = "/users/home";
		public static final String WS_USER_REQUEST_APPOINTMENT = "/users/request/appointment";
		public static final String WS_USER_APPROVE_APPOINTMENT = "/users/approve/appointment";
		public static final String WS_USER_DECLINE_APPOINTMENT = "/users/decline/appointment";
		public static final String WS_USER_CANCEL_APPOINTMENT = "/users/cancel/appointment";
		public static final String WS_USER_RESCHEDULE_APPOINTMENT = "/users/reschedule/appointment";
		public static final String WS_USER_COMPLETE_APPOINTMENT = "/users/complete/appointment";
	}
	
	public static class ServiceConsumerWS{
		public static final String WS_CONSUMER_SIGN_UP = "/consumer/register";
		public static final String WS_CONSUMER_AUTHENDICATE = "/consumer/authendicate";
		public static final String WS_CONSUMER_HOME = "/consumer/home";
		public static final String WS_CONSUMER_SEARCH_SERVICE = "/consumer/search/service";
		public static final String WS_CONSUMER_REQUEST_APPOINTMENT = "/consumer/request/appointment";
		public static final String WS_CONSUMER_CANCEL_APPOINTMENT = "/consumer/cancel/appointment";
		public static final String WS_CONSUMER_APPOINTMENT_REMINDER = "/consumer/appointment/reminder";
		public static final String WS_CONSUMER_NAVIGATE_SERVICE = "/consumer/nav/service";
		//public static final String WS_CONSUMER_APPOINTMENT_DETAILS = "/consumer/appointment/details";
	}
	
	public static class ServiceProviderWS{
		public static final String WS_SERVICE_PROVIDER_REGISTER = "/serviceprovider/register";
		public static final String WS_SERVICE_PROVIDER_AUTHENDICATE = "/serviceprovider/authendicate";
		public static final String WS_SERVICE_PROVIDER_HOME = "/serviceprovider/home";
		public static final String WS_SERVICE_PROVIDER_APPROVE_APPOINTMENT = "/serviceprovider/approve/appointment";
		public static final String WS_SERVICE_PROVIDER_DECLINE_APPOINTMENT = "/serviceprovider/decline/appointment";
	}
	
	public static class ServiceWS{
		public static final String WS_SERVICE_REGISTER = "/service/register";
		public static final String WS_SERVICE_DEREGISTER = "/service/deregister";
		public static final String WS_SERVICE_VERIFY = "/service/verify";
		public static final String WS_SERVICE_HOME = "/service/home";
		public static final String WS_SERVICE_DETAIL = "/service/details";
	}
	
	
	
	public static class StaticWS{
		public static final String WS_FETCH_ANY_TYPE = "/static/any";
		public static final String WS_FETCH_ANY_ACTIVE_TYPE = "/static/any/active";
	}
	
	public static class AppointmentWS{
		public static final String WS_BOOK_APPOINTMENT = "/book/consumer/appointment/create";
		public static final String WS_VIEW_APPOINTMENT_DETAILS = "/book/consumer/appointment/view";
		public static final String WS_ALL_APPOINTMENTS_BY_CONSUMER = "/book/consumer/appointment/list/all";
		public static final String WS_ALL_ACTIVE_APPOINTMENTS_BY_CONSUMER = "/book/consumer/appointment/list/active";
		public static final String WS_APPOINTMENT_CANCEL_BY_CONSUMER = "/book/consumer/appointment/cancel";
		public static final String WS_APPOINTMENT_RESCHEDULE_BY_CONSUMER = "/book/consumer/appointment/reschedule";
		
		public static final String WS_CREATE_SCHEDULE_BY_ISP = "/book/isp/schedule/create";
		public static final String WS_VIEW_SCHEDULE_DETAILS_BY_ISP = "/book/isp/schedule/view";
		public static final String WS_ALL_SCHEDULES_BY_ISP = "/book/isp/schedule/list/all";
		public static final String WS_ALL_ACTIVE_SCHEDULES_BY_ISP = "/book/isp/schedule/list/active";
		public static final String WS_ALL_SCHEDULES_DONE_BY_ISP = "/book/isp/scheWdule/list/isp";
		public static final String WS_ALL_ACTIVE_SCHEDULES_DONE_BY_ISP = "/book/isp/schedule/list/active/isp";
		public static final String WS_SCHEDULE_CANCEL_BY_ISP = "/book/isp/schedule/cancel";
		public static final String WS_SCHEDULE_CONFIRM_BY_ISP = "/book/isp/schedule/confirm";
		public static final String WS_SCHEDULE_RESCHEDULE_BY_ISP = "/book/isp/schedule/reschedule";
	}
}