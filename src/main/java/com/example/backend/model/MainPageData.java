package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "main_page_data")
@Data
@NoArgsConstructor
public class MainPageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "hostname")
    private String hostname;

    @Column(name = "header_address")
    private String headerAddress;

    @Column(name = "header_phone_number")
    private String headerPhoneNumber;

    @Column(name = "header_logo_path")
    private String headerLogoPath;

    @Column(name = "banner_head_line")
    private String bannerHeadLine;

    @Column(name = "banner_promo")
    private String bannerPromo;

    @Column(name = "banner_logo_path")
    private String bannerLogoPath;

    @Column(name = "menu_head_line")
    private String menuHeadLine;

    @Column(name = "menu_card_title_1")
    private String menuCardTitle1;

    @Column(name = "menu_card_photo_1")
    private String menuCardPhoto1;

    @Column(name = "menu_card_title_2")
    private String menuCardTitle2;

    @Column(name = "menu_card_photo_2")
    private String menuCardPhoto2;

    @Column(name = "menu_card_title_3")
    private String menuCardTitle3;

    @Column(name = "menu_card_photo_3")
    private String menuCardPhoto3;

    @Column(name = "menu_card_title_4")
    private String menuCardTitle4;

    @Column(name = "menu_card_photo_4")
    private String menuCardPhoto4;

    @Column(name = "menu_card_title_5")
    private String menuCardTitle5;

    @Column(name = "menu_card_photo_5")
    private String menuCardPhoto5;

    @Column(name = "menu_card_title_6")
    private String menuCardTitle6;

    @Column(name = "menu_card_photo_6")
    private String menuCardPhoto6;

    @Column(name = "menu_card_title_7")
    private String menuCardTitle7;

    @Column(name = "menu_card_photo_7")
    private String menuCardPhoto7;

    @Column(name = "menu_card_title_8")
    private String menuCardTitle8;

    @Column(name = "menu_card_photo_8")
    private String menuCardPhoto8;

    @Column(name = "menu_frame_default_title")
    private String menuFrameDefaultTitle;

    @Column(name = "menu_pin_name_1")
    private String menuPinName1;

    @Column(name = "menu_pin_name_2")
    private String menuPinName2;

    @Column(name = "menu_pin_name_3")
    private String menuPinName3;

    @Column(name = "menu_pin_name_4")
    private String menuPinName4;

    @Column(name = "menu_pin_name_5")
    private String menuPinName5;

    @Column(name = "about_head_line")
    private String aboutHeadLine;

    @Column(name = "about_item_1")
    private String aboutItem1;

    @Column(name = "about_item_2")
    private String aboutItem2;

    @Column(name = "about_item_3")
    private String aboutItem3;

    @Column(name = "about_item_4")
    private String aboutItem4;

    @Column(name = "about_item_5")
    private String aboutItem5;

    @Column(name = "about_item_6")
    private String aboutItem6;

    @Column(name = "contacts_head_line")
    private String contactsHeadLine;

    @Column(name = "contacts_map_path")
    private String contactsMapPath;

    @Column(name = "contacts_address")
    private String contactsAddress;

    @Column(name = "contacts_phone_1")
    private String contactsPhone1;

    @Column(name = "contacts_phone_2")
    private String contactsPhone2;

    @Column(name = "contacts_time")
    private String contactsTime;

    @Column(name = "contacts_delivery_terms")
    private String contactsDeliveryTerms;

    @Column(name = "footer_logo_path")
    private String footerLogoPath;

    @Column(name = "footer_logo_info")
    private String footerLogoInfo;

    @Column(name = "footer_logo_title")
    private String footerLogoTitle;

    @Column(name = "footer_important_title")
    private String footerImportantTitle;

    @Column(name = "footer_important_personal")
    private String footerImportantPersonal;

    @Column(name = "footer_important_pay_terms")
    private String footerImportantPayTerms;

    @Column(name = "footer_important_qa")
    private String footerImportantQA;

    @Column(name = "footer_menu_set_1")
    private String footerMenuSet1;

    @Column(name = "footer_menu_set_2")
    private String footerMenuSet2;

    @Column(name = "footer_menu_set_3")
    private String footerMenuSet3;

    @Column(name = "footer_menu_set_4")
    private String footerMenuSet4;

    @Column(name = "footer_menu_set_5")
    private String footerMenuSet5;

    @Column(name = "footer_menu_set_6")
    private String footerMenuSet6;

    @Column(name = "footer_menu_set_7")
    private String footerMenuSet7;

    @Column(name = "footer_menu_set_8")
    private String footerMenuSet8;

    @Column(name = "footer_menu_pay_title")
    private String footerMenuPayTitle;

    @Column(name = "footer_phone_1")
    private String footerPhone1;

    @Column(name = "footer_phone_2")
    private String footerPhone2;

}
