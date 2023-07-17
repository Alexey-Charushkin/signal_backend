package com.example.backend.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MainPageDataDTO {

    private Long pageId;

    @NotBlank
    private String hostname;

    @NotBlank
    private String headerAddress;

    @NotBlank
    private String headerPhoneNumber;

    @NotBlank
    private String headerLogoPath;

    @NotBlank
    private String bannerHeadLine;

    @NotBlank
    private String bannerPromo;

    @NotBlank
    private String bannerLogoPath;

    @NotBlank
    private String menuHeadLine;

    @NotBlank
    private String menuCardTitle1;

    @NotBlank
    private String menuCardPhoto1;

    @NotBlank
    private String menuCardTitle2;

    @NotBlank
    private String menuCardPhoto2;

    @NotBlank
    private String menuCardTitle3;

    @NotBlank
    private String menuCardPhoto3;

    @NotBlank
    private String menuCardTitle4;

    @NotBlank
    private String menuCardPhoto4;

    @NotBlank
    private String menuCardTitle5;

    @NotBlank
    private String menuCardPhoto5;

    @NotBlank
    private String menuCardTitle6;

    @NotBlank
    private String menuCardPhoto6;

    @NotBlank
    private String menuCardTitle7;

    @NotBlank
    private String menuCardPhoto7;

    @NotBlank
    private String menuCardTitle8;

    @NotBlank
    private String menuCardPhoto8;

    @NotBlank
    private String menuFrameDefaultTitle;

    @NotBlank
    private String menuPinName1;

    @NotBlank
    private String menuPinName2;

    @NotBlank
    private String menuPinName3;

    @NotBlank
    private String menuPinName4;

    @NotBlank
    private String menuPinName5;

    @NotBlank
    private String aboutHeadLine;

    @NotBlank
    private String aboutItem1;

    @NotBlank
    private String aboutItem2;

    @NotBlank
    private String aboutItem3;

    @NotBlank
    private String aboutItem4;

    @NotBlank
    private String aboutItem5;

    @NotBlank
    private String aboutItem6;

    @NotBlank
    private String contactsHeadLine;

    @NotBlank
    private String contactsMapPath;

    @NotBlank
    private String contactsAddress;

    @NotBlank
    private String contactsPhone1;

    @NotBlank
    private String contactsPhone2;

    @NotBlank
    private String contactsTime;

    @NotBlank
    private String contactsDeliveryTerms;

    @NotBlank
    private String footerLogoPath;

    @NotBlank
    private String footerLogoInfo;

    @NotBlank
    private String footerLogoTitle;

    @NotBlank
    private String footerImportantTitle;

    @NotBlank
    private String footerImportantPersonal;

    @NotBlank
    private String footerImportantPayTerms;

    @NotBlank
    private String footerImportantQA;

    @NotBlank
    private String footerMenuSet1;

    @NotBlank
    private String footerMenuSet2;

    @NotBlank
    private String footerMenuSet3;

    @NotBlank
    private String footerMenuSet4;

    @NotBlank
    private String footerMenuSet5;

    @NotBlank
    private String footerMenuSet6;

    @NotBlank
    private String footerMenuSet7;

    @NotBlank
    private String footerMenuSet8;

    @NotBlank
    private String footerMenuPayTitle;

    @NotBlank
    private String footerPhone1;

    @NotBlank
    private String footerPhone2;

}
