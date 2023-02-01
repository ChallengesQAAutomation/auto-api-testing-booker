package model.Booking.request;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RequestBooking{
	private String firstname;
	private String additionalneeds;
	private Bookingdates bookingdates;
	private int totalprice;
	private boolean depositpaid;
	private String lastname;

	public String getFirstname(){
		return firstname;
	}

	public String getAdditionalneeds(){
		return additionalneeds;
	}

	public Bookingdates getBookingdates(){
		return bookingdates;
	}

	public int getTotalprice(){
		return totalprice;
	}

	public boolean isDepositpaid(){
		return depositpaid;
	}

	public String getLastname(){
		return lastname;
	}

	public static class Builder {
		final Faker faker = new Faker(Locale.ENGLISH);
		private String firstnameBuild= String.valueOf(faker.name());
		private String additionalneedsBuild;
		private Bookingdates bookingdatesBuild;
		private int totalpriceBuild=faker.number().numberBetween(4,5);
		private boolean depositpaidBuild=true;
		private String lastnameBuild=faker.gameOfThrones().house();

		public Builder withAdditionalneeds(String additionalneeds) {
			this.additionalneedsBuild = additionalneeds;
			return this;
		}
		public Builder withDate(String checkin,String checkout) {
			Bookingdates bookingdatesnew = new Bookingdates.Builder().withChekin(checkin).withChekout(checkout).build();
			this.bookingdatesBuild = bookingdatesnew;
			return this;
		}

		public RequestBooking build() {
			RequestBooking data = new RequestBooking();
			data.firstname = firstnameBuild;
			data.additionalneeds = additionalneedsBuild;
			data.bookingdates = bookingdatesBuild;
			data.totalprice = totalpriceBuild;
			data.depositpaid = depositpaidBuild;
			data.lastname = lastnameBuild;
			return data;
		}
	}
}
