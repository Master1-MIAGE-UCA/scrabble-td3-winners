package data;

public class message {


        private String message;

        public message() {
        }

        public message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Greeting{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }

