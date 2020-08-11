package sample.dom4j;

import java.util.List;

public class MultAcceptDTO extends TradeDTO {

    private List<ContDTO> contList;

    public List<ContDTO> getContList() {
        return contList;
    }

    public void setContList(List<ContDTO> contList) {
        this.contList = contList;
    }

}
