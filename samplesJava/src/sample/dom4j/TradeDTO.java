package sample.dom4j;

public class TradeDTO {

    private String bankcode;
    private String funcflag;
    private String businessNo;
    private boolean isRepeatTrade;
    private String localIp;

    private TransstatusDTO transstatusDTO;

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode;
    }

    public String getFuncflag() {
        return funcflag;
    }

    public void setFuncflag(String funcflag) {
        this.funcflag = funcflag;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public TransstatusDTO getTransstatusDTO() {
        return transstatusDTO;
    }

    public void setTransstatusDTO(TransstatusDTO transstatusDTO) {
        this.transstatusDTO = transstatusDTO;
    }

    public boolean isRepeatTrade() {
        return isRepeatTrade;
    }

    public void setRepeatTrade(boolean isRepeatTrade) {
        this.isRepeatTrade = isRepeatTrade;
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp;
    }

}
