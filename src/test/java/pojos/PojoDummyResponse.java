package pojos;

public class PojoDummyResponse {

/*
       {
          "status": "success",
          "data": {
                "id": 3,
                "employee_name": "Ashton Cox",
                "employee_salary": 86000,
                "employee_age": 66,
                "profile_image": ""
                   },
          "message": "Successfully! Record has been fetched."
       }
 */

    //1-
    private String status;
    private PojoDummyData data;
    private String message;

    //2-
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PojoDummyData getData() {
        return data;
    }

    public void setData(PojoDummyData data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //3-
    public PojoDummyResponse(String status, PojoDummyData data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    //4-
    public PojoDummyResponse() {
    }

    //5-
    @Override
    public String toString() {
        return "PojoDummyResponse{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
