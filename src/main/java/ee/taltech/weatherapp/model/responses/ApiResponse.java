package ee.taltech.weatherapp.model.responses;

import lombok.Data;

@Data
public class ApiResponse {
    private boolean success;
    private Object data;
}
