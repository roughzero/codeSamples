/*
 * Created on 2015年5月9日
 */
package sample.dom4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class SampleOfReadDocument {

    protected static Log logger = LogFactory.getLog(SampleOfReadDocument.class);

    public MultAcceptDTO transferBySelect(Document doc, String funcflag) {
        MultAcceptDTO multAcceptDTO = new MultAcceptDTO();

        multAcceptDTO.setFuncflag(funcflag);

        String bankcode = doc.selectSingleNode("/TranData/BaseInfo/BankCode").getText();
        String bankDate = doc.selectSingleNode("/TranData/BaseInfo/BankDate").getText();
        String bankTime = doc.selectSingleNode("/TranData/BaseInfo/BankTime").getText();

        String batchNo = doc.selectSingleNode("/TranData/LCGrpContS/BatchNo").getText();
        String payTransrNo = doc.selectSingleNode("/TranData/LCGrpContS/PayTransrNo").getText();

        multAcceptDTO.setBankcode(bankcode);
        multAcceptDTO.setBusinessNo(payTransrNo);

        TransstatusDTO transstatusDTO = new TransstatusDTO();
        transstatusDTO.setTransdate(DateUtil.getDate(bankDate));
        transstatusDTO.setTranstime(bankTime);
        transstatusDTO.setBatchno(batchNo);
        transstatusDTO.setTradeno(payTransrNo);
        transstatusDTO.setTranscode(batchNo);

        List<ContDTO> contList = new ArrayList<ContDTO>();

        List<Node> grpContList = doc.selectNodes("/TranData/LCGrpContS/LCGrpCont");
        for (Node grpContNode : grpContList) {
            ContDTO contDto = new ContDTO();
            contDto.setBatchno(batchNo);
            contDto.setBak2(payTransrNo);
            contDto.setBankcode(bankcode);

            contDto.setTransdate(transstatusDTO.getTransdate());
            contDto.setTranstime(transstatusDTO.getTranstime());

            Node cValiDateNode = grpContNode.selectSingleNode("CValiDate");
            Node cValiTimeNode = grpContNode.selectSingleNode("CValiTime");
            Node flightNoNode = grpContNode.selectSingleNode("FlightNo");

            contDto.setCvalidate(DateUtil.getDate(cValiDateNode.getText()));
            contDto.setCvalitime(cValiTimeNode.getText());
            contDto.setFlightno(flightNoNode.getText());

            Node appntNameNode = grpContNode.selectSingleNode("LCAppnt/AppntName");
            Node appntSexNode = grpContNode.selectSingleNode("LCAppnt/AppntSex");
            Node appntBirthdayNode = grpContNode.selectSingleNode("LCAppnt/AppntBirthday");
            Node appntIDTypeNode = grpContNode.selectSingleNode("LCAppnt/AppntIDType");
            Node appntIDNoNode = grpContNode.selectSingleNode("LCAppnt/AppntIDNo");

            contDto.setAppntname(appntNameNode.getText());
            contDto.setAppntsex(appntSexNode.getText());
            contDto.setAppntbirthday(DateUtil.getDate(appntBirthdayNode.getText()));
            contDto.setAppntidtype(appntIDTypeNode.getText());
            contDto.setAppntidno(appntIDNoNode.getText());

            Node insuNameNode = grpContNode
                    .selectSingleNode("LCConts/LCCont/LCInsureds/LCInsured/Name");
            Node insuSexNode = grpContNode
                    .selectSingleNode("LCConts/LCCont/LCInsureds/LCInsured/Sex");
            Node insuBirthdayNode = grpContNode
                    .selectSingleNode("LCConts/LCCont/LCInsureds/LCInsured/Birthday");
            Node insuIDTypeNode = grpContNode
                    .selectSingleNode("LCConts/LCCont/LCInsureds/LCInsured/IDType");
            Node insuIDNoNode = grpContNode
                    .selectSingleNode("LCConts/LCCont/LCInsureds/LCInsured/IDNo");

            contDto.setInsuname(insuNameNode.getText());
            contDto.setInsusex(insuSexNode.getText());
            contDto.setInsubirthday(DateUtil.getDate(insuBirthdayNode.getText()));
            contDto.setInsuidtype(insuIDTypeNode.getText());
            contDto.setInsuidno(insuIDNoNode.getText());

            Node riskCodeNode = grpContNode.selectSingleNode(
                    "LCConts/LCCont/LCInsureds/LCInsured/Risks/Risk/RiskCode");
            contDto.setPlancode(riskCodeNode.getText());

            contList.add(contDto);
        }

        multAcceptDTO.setTransstatusDTO(transstatusDTO);
        multAcceptDTO.setContList(contList);

        return multAcceptDTO;
    }

    public MultAcceptDTO transferByElement(Document doc, String funcflag) {
        MultAcceptDTO multAcceptDTO = new MultAcceptDTO();

        multAcceptDTO.setFuncflag(funcflag);

        Element root = doc.getRootElement();

        String bankcode = root.element("BaseInfo").elementText("BankCode");
        String bankDate = root.element("BaseInfo").elementText("BankDate");
        String bankTime = root.element("BaseInfo").elementText("BankTime");

        String batchNo = root.element("LCGrpContS").elementText("BatchNo");
        String payTransrNo = root.element("LCGrpContS").elementText("PayTransrNo");

        multAcceptDTO.setBankcode(bankcode);
        multAcceptDTO.setBusinessNo(payTransrNo);

        TransstatusDTO transstatusDTO = new TransstatusDTO();
        transstatusDTO.setTransdate(DateUtil.getDate(bankDate));
        transstatusDTO.setTranstime(bankTime);
        transstatusDTO.setBatchno(batchNo);
        transstatusDTO.setTradeno(payTransrNo);
        transstatusDTO.setTranscode(batchNo);

        List<ContDTO> contList = new ArrayList<ContDTO>();

        Element grpContsElement = root.element("LCGrpContS");
        List<Element> grpContList = grpContsElement.element("LCGrpCont").element("LCConts")
                .elements("LCCont");
        for (@SuppressWarnings("rawtypes")
             Iterator it = grpContList.iterator(); it.hasNext(); ) {
            Element contElement = (Element) it.next();
            ContDTO contDto = new ContDTO();
            contDto.setBatchno(batchNo);
            contDto.setBak2(payTransrNo);
            contDto.setBankcode(bankcode);

            contDto.setTransdate(transstatusDTO.getTransdate());
            contDto.setTranstime(transstatusDTO.getTranstime());

            String cValiDateString = grpContsElement.elementText("CValiDate");
            String cValiTimeString = grpContsElement.elementText("CValiTime");
            String flightNoString = grpContsElement.elementText("FlightNo");

            contDto.setCvalidate(DateUtil.getDate(cValiDateString));
            contDto.setCvalitime(cValiTimeString);
            contDto.setFlightno(flightNoString);

            Element appntElement = grpContsElement.element("LCGrpCont").element("LCAppnt");
            String appntNameNode = appntElement.elementText("AppntName");
            String appntSexNode = appntElement.elementText("AppntSex");
            String appntBirthdayNode = appntElement.elementText("AppntBirthday");
            String appntIDTypeNode = appntElement.elementText("AppntIDType");
            String appntIDNoNode = appntElement.elementText("AppntIDNo");

            contDto.setAppntname(appntNameNode);
            contDto.setAppntsex(appntSexNode);
            contDto.setAppntbirthday(DateUtil.getDate(appntBirthdayNode));
            contDto.setAppntidtype(appntIDTypeNode);
            contDto.setAppntidno(appntIDNoNode);

            Element lcinsuredElement = contElement.element("LCInsureds").element("LCInsured");
            String insuNameNode = lcinsuredElement.elementText("Name");
            String insuSexNode = lcinsuredElement.elementText("Sex");
            String insuBirthdayNode = lcinsuredElement.elementText("Birthday");
            String insuIDTypeNode = lcinsuredElement.elementText("IDType");
            String insuIDNoNode = lcinsuredElement.elementText("IDNo");

            contDto.setInsuname(insuNameNode);
            contDto.setInsusex(insuSexNode);
            contDto.setInsubirthday(DateUtil.getDate(insuBirthdayNode));
            contDto.setInsuidtype(insuIDTypeNode);
            contDto.setInsuidno(insuIDNoNode);

            String riskCodeNode = lcinsuredElement.element("Risks").element("Risk")
                    .elementText("RiskCode");
            contDto.setPlancode(riskCodeNode);

            contList.add(contDto);
        }

        multAcceptDTO.setTransstatusDTO(transstatusDTO);
        multAcceptDTO.setContList(contList);

        return multAcceptDTO;
    }

    public static void main(String[] args) throws DocumentException {

        String xmlContent = "<TranData> <BaseInfo> <BankDate>20150503</BankDate> <BankTime>17:57:02</BankTime> <BankCode>46</BankCode> <ZoneNo>8611</ZoneNo> <BrNo>BJQNKJ</BrNo> <TellerNo>901010900003</TellerNo> <TransrNo /> <FunctionFlag>M1</FunctionFlag> <InsuID>001</InsuID> <Contflag /> </BaseInfo> <LCGrpContS> <LCGrpContCount>1</LCGrpContCount> <BatchNo>hus15050317361182008</BatchNo> <PayTransrNo>B1505031737128685310</PayTransrNo> <PayPlat>4</PayPlat> <LCGrpCont> <ProposalGrpContNo /> <PrtNo /> <PolApplyDate>20150503</PolApplyDate> <CValiDate>20150504</CValiDate> <ContStartDate>20150504</ContStartDate> <ContEndDate>20150505</ContEndDate> <CValiTime>06:40:00</CValiTime> <FlightNo>CA4589</FlightNo> <LoanStartDate /> <LoanEndDate /> <LoanContractNo /> <LoanContractAmt /> <AccName /> <AccBankCode /> <BankAccNo /> <PayIntv /> <PayMode /> <GetPolMode /> <Password /> <SpecContent /> <TempFeeNo /> <AgentCode /> <AgentGroup /> <AgentName /> <LCAppnt> <AppntName>杨琴</AppntName> <AppntSex>1</AppntSex> <AppntBirthday>19880929</AppntBirthday> <AppntIDType>0</AppntIDType> <AppntIDNo>513701198809294028</AppntIDNo> <AppntOfficePhone /> <AppntMobile>1380013800</AppntMobile> <AppntPhone>1380013800</AppntPhone> <MailAddress /> <MailZipCode /> <HomeAddress /> <HomeZipCode /> <JobCode>9999999</JobCode> <RelaToMain>00</RelaToMain> <RelaToInsured>00</RelaToInsured> <AppntEmail>1380013800</AppntEmail> </LCAppnt> <LCConts> <LCCont> <LCInsureds> <LCInsuredCount>1</LCInsuredCount> <LCInsured> <Name>杨琴</Name> <Sex>1</Sex> <Birthday>19880929</Birthday> <IDType>0</IDType> <IDNo>513701198809294028</IDNo> <JobCode>9999999</JobCode> <HomeAddress /> <HomeZipCode /> <HomePhone>1380013800</HomePhone> <RelaToMain>00</RelaToMain> <RelaToAppnt>00</RelaToAppnt> <Risks> <RiskCount>1</RiskCount> <Risk> <RiskCode>578200</RiskCode> <MainRiskCode>578200</MainRiskCode> <RiskType /> <RiskName /> <Amnt>200</Amnt> <Prem /> <Mult>1</Mult> <Rank /> <PayIntv /> <CostIntv /> <CostDate /> <Years /> <SpecContent /> <PayEndYearFlag /> <PayEndYear /> <GetYearFlag /> <GetYear /> <InsuYearFlag /> <InsuYear /> <GetIntv /> <GetBankCode /> <GetBankAccNo /> <GetAccName /> <AutoPayFlag /> <BonusPayMode /> <SubFlag /> <BonusGetMode /> <HealthFlag /> <FullBonusGetMode /> <FirstRate /> <SureRate /> <LCBnfs> <LCBnfCount>1</LCBnfCount> <LCBnf> <Name>法定</Name> <Sex>0</Sex> <BnfType>1</BnfType> <BnfNo>1</BnfNo> <BnfGrade>1</BnfGrade> <Birthday>1000-00-00</Birthday> <IDType>2</IDType> <IDNo>123</IDNo> <BelongToInsured>00</BelongToInsured> <RelationToInsured>00</RelationToInsured> <BnfLot>1</BnfLot> </LCBnf> </LCBnfs> </Risk> </Risks> </LCInsured> </LCInsureds> </LCCont> </LCConts> </LCGrpCont> </LCGrpContS> </TranData>";

        // init tools.
        Document document = DocumentHelper.parseText("<test></test>");
        SAXReader reader = new SAXReader();
        document = reader.read(new File("QUR_accept_46.xml"));

        logger.info("start");

        long startTime = System.nanoTime();
        // document = reader.read(new File("QUR_accept_46.xml"));
        document = DocumentHelper.parseText(xmlContent);

        long cost = System.nanoTime() - startTime;
        logger.info("read first time finished. cost " + cost / 1000000 + "  milliseconds ."); // 1 millisecond = 1000000 nanosecoends

        startTime = System.nanoTime();
        document = DocumentHelper.parseText(xmlContent);

        cost = System.nanoTime() - startTime;
        logger.info("read second time finished. cost " + cost / 1000000 + "  milliseconds ."); // 1 millisecond = 1000000 nanosecoends

        startTime = System.nanoTime();
        SampleOfReadDocument sample = new SampleOfReadDocument();

        logger.info("transferBySelect started.");
        sample.transferBySelect(document, "M1");
        cost = System.nanoTime() - startTime;
        logger.info("transferBySelect ended. cost " + cost / 1000000 + " milliseconds.");

        startTime = System.nanoTime();
        sample = new SampleOfReadDocument();

        logger.info("transferByElement started...");
        for (int i = 0; i < 1000; i++)
            sample.transferByElement(document, "M1");
        cost = System.nanoTime() - startTime;
        logger.info("transferByElement ended. cost " + cost / 1000000 + " milliseconds.");
    }
}
