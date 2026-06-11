package imnider.learning.springboot.helloworld.models.dto;

public class ParamDto {
    private String message;
    private Integer code;

    public ParamDto() {
    }
    
    public ParamDto(String message) {
        this.message = message;
    }

    public ParamDto(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
