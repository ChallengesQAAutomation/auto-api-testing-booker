package model.Booking.request;

public class Bookingdates{
	private String checkin;
	private String checkout;

	public String getCheckin(){
		return checkin;
	}

	public String getCheckout(){
		return checkout;
	}

	public static class Builder {
		private String checkinBuild;
		private String checkoutBuild;

		public Bookingdates.Builder withChekin(String checkin) {
			this.checkinBuild = checkin;
			return this;
		}

		public Bookingdates.Builder withChekout(String checkout) {
			this.checkoutBuild = checkout;
			return this;
		}
		public Bookingdates build() {
			Bookingdates data = new Bookingdates();
			data.checkin = checkinBuild;
			data.checkout = checkoutBuild;
			return data;
		}

	}
}
