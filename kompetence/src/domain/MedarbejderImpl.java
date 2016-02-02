package domain;

public class MedarbejderImpl implements Medarbejder {
 
        private String navn;
        private String email;
        

		public MedarbejderImpl(String navn, String email) {
            this.navn = navn;
            this.email = email;
            
        }


		public String getNavn() {
			return navn;
		}


		public void setNavn(String navn) {
			this.navn = navn;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		@Override
		public String toString() {
			return "MedarbejderImpl [navn=" + navn + ", email=" + email + "]";
		}

}