public class Order {

		private String ship_time;
		private String ship_date;
		private String ship_info;
		private double Price ;
		private int Oid;
		private int Sid;
		private int Vnumber;
		

		public Order(int Order_id , int Service_id,int Vehicle_number,double PriceOfOrder,String shipping_time,String ship_date,String shipping_info) {
			super();
			this.ship_date = ship_date;
			ship_time = shipping_time;
			ship_info = shipping_info;
			Price = PriceOfOrder;
			Oid= Order_id;
			Sid = Service_id;
			Vnumber = Vehicle_number;
		
		}

		public Order(int Order_id,int Service_id,int Vehicle_number,double PriceOfOrder,String shipping_time,String ship_date) {
			super();
			this.ship_date = ship_date;

			ship_time = shipping_time;
			Price = PriceOfOrder;
			Oid= Order_id;
			Sid = Service_id;
			Vnumber = Vehicle_number;
			
		
		}
		public Order(int Oid) {
			super();
			this.Oid = Oid;
			
		}
		
		
		
		public String getShip_time() {
			return ship_time;
		}


		public void setShip_time(String ship_time) {
			this.ship_time = ship_time;
		}


		public String getShip_date() {
			return ship_date;
		}

		public void setShip_date(String ship_date) {
			this.ship_date = ship_date;
		}

		public String getShip_info() {
			return ship_info;
		}


		public void setShip_info(String ship_info) {
			this.ship_info = ship_info;
		}


		public double getPrice() {
			return Price;
		}


		public void setPrice(int price) {
			Price = price;
		}


		public int getOid() {
			return Oid;
		}


		public void setOid(int oid) {
			Oid = oid;
		}


		public int getSid() {
			return Sid;
		}


		public void setSid(int sid) {
			Sid = sid;
		}


		public int getVnumber() {
			return Vnumber;
		}


		public void setVnumber(int vnumber) {
			Vnumber = vnumber;
		}

}