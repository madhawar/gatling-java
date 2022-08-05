package SelfServRenewal;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class SelfServRenewal extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://uat06sts.intertrav.co.uk")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .doNotTrackHeader("1")
    .userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:102.0) Gecko/20100101 Firefox/102.0");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "none"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("Accept", "text/css,*/*;q=0.1"),
    Map.entry("Sec-Fetch-Dest", "style"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("Sec-Fetch-Dest", "script"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_6 = Map.ofEntries(
    Map.entry("Accept", "image/avif,image/webp,*/*"),
    Map.entry("Sec-Fetch-Dest", "image"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_7 = Map.ofEntries(
    Map.entry("Accept", "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8"),
    Map.entry("Accept-Encoding", "identity"),
    Map.entry("Sec-Fetch-Dest", "font"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_9 = Map.ofEntries(
    Map.entry("Accept", "application/font-woff2;q=1.0,application/font-woff;q=0.9,*/*;q=0.8"),
    Map.entry("Sec-Fetch-Dest", "font"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin")
  );
  
  private Map<CharSequence, String> headers_10 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"),
    Map.entry("Origin", "https://uat06sts.intertrav.co.uk"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_13 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );


  private ScenarioBuilder scn = scenario("SelfServRenewal")
    .exec(
      http("/mystaysure/signin")
        .get("/mystaysure/signin")
        .headers(headers_0)
              .check(regex( "<input type=\"hidden\" name=\"_csrf\" value=\"(.+?)\"/>" ).saveAs("csrf"))
        .resources(
          http("request_1")
            .get("/mystaysure/resources/css/private/style.css?relversion=4.9.0.1")
            .headers(headers_1),
          http("request_2")
            .get("/mystaysure/resources/js/private/master.js?relversion=4.9.0.1")
            .headers(headers_2),
          http("request_3")
            .get("/mystaysure/resources/js/private/utils.js?relversion=4.9.0.1")
            .headers(headers_2),
          http("request_4")
            .get("/mystaysure/resources/js/private/signin.js?relversion=4.9.0.1")
            .headers(headers_2),
          http("request_5")
            .get("/mystaysure/resources/js/private/error.js?relversion=4.9.0.1")
            .headers(headers_2),
          http("request_6")
            .get("/mystaysure/resources/images/logo.svg")
            .headers(headers_6),
          http("request_7")
            .get("/mystaysure/resources/fonts/font-awesome/fontawesome-webfont.woff2?v=4.7.0")
            .headers(headers_7),
          http("request_8")
            .get("/mystaysure/resources/fonts/font-awesome/fontawesome-webfont.woff?v=4.7.0")
            .headers(headers_7),
          http("request_9")
            .get("/mystaysure/resources/fonts/font-awesome/fontawesome-webfont.ttf?v=4.7.0")
            .headers(headers_9),
          http("/mystaysure/signin")
            .post("/mystaysure/signin")
            .headers(headers_10)
            .formParam("_csrf", "69a734fb-aedd-48b2-835e-f0a6154d7c62")
            .formParam("username", "randikatesting@gmail.com")
            .formParam("password", "January*27")
            .formParam("targetUrl", ""),
          http("request_11")
            .get("/mystaysure/resources/js/private/loader.js?relversion=4.9.0.1")
            .headers(headers_2),
          http("request_12")
            .get("/mystaysure/resources/js/private/onBoard.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("/mystaysure/my-renewals")
        .get("/mystaysure/my-renewals")
        .headers(headers_13)
        .resources(
          http("request_14")
            .get("/mystaysure/resources/js/private/myPolicies.js?relversion=4.9.0.1")
            .headers(headers_2),
          http("request_15")
            .get("/mystaysure/resources/images/icon-amt.svg")
            .headers(headers_6),
          http("request_16")
            .get("/mystaysure/resources/js/private/ajax-support.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(3)
    .exec(
      http("/mystaysure/load-for-renewal")
        .post("/mystaysure/load-for-renewal")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("renewalModalType", "autoRenewalStatementModal2V2OptIn")
        .formParam("policyId", "adc20979e31f6c2a8875d8e4677c7d71657ba94939c5001b9d2a741e2218dcb4")
        .resources(
          http("request_18")
            .get("/mystaysure/resources/js/private/renewal/personalDetails.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("/mystaysure/amend-renewal-personal-details")
        .post("/mystaysure/amend-renewal-personal-details")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("id", "2430")
        .formParam("myAccRenewalInfoDTO.formChanged", "false")
        .formParam("auth", "93b0b5ab038e0474e5b14e889a26a2a1dadc5ecb3fe4affd30279219b17bbffc")
        .formParam("organiserDTO.title", "Miss")
        .formParam("dob", "01/01/1992")
        .formParam("organiserDTO.dayTimeTelephone", "0712617753")
        .formParam("organiserDTO.postcode", "NN47YB")
        .formParam("organiserDTO.address1", "Britannia House")
        .formParam("organiserDTO.address2", "Rushmills")
        .formParam("organiserDTO.city", "Northampton")
        .formParam("organiserDTO.county", "")
        .formParam("marketingConsentDTO.telephone", "false")
        .formParam("marketingConsentDTO.email", "false")
        .formParam("marketingConsentDTO.post", "false")
        .formParam("marketingConsentDTO.sms", "false")
        .resources(
          http("request_20")
            .get("/mystaysure/resources/js/private/renewal/tripDetails.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("/mystaysure/amend-renewal-trip-details")
        .post("/mystaysure/amend-renewal-trip-details")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("id", "2430")
        .formParam("myAccRenewalInfoDTO.formChanged", "false")
        .formParam("myAccRenewalInfoDTO.priceCalculationRequired", "false")
        .formParam("auth", "93b0b5ab038e0474e5b14e889a26a2a1dadc5ecb3fe4affd30279219b17bbffc")
        .formParam("travelInformationDTO.area", "WORLD_HR")
        .formParam("travelInformationDTO.goingOnCruise", "N")
        .formParam("travelInformationDTO.quoteTravelers[0].sequence", "1")
        .formParam("travelInformationDTO.quoteTravelers[0].id", "2863")
        .formParam("travelInformationDTO.quoteTravelers[0].title", "Miss")
        .formParam("travelInformationDTO.quoteTravelers[0].firstName", "Fd")
        .formParam("travelInformationDTO.quoteTravelers[0].lastName", "Sdfd")
        .formParam("travelInformationDTO.quoteTravelers[0].age", "30")
        .formParam("travelInformationDTO.quoteTravelers[0].fullTimeEducation", "false")
        .formParam("travelInformationDTO.partyType", "INDIVIDUAL")
        .resources(
          http("request_22")
            .get("/mystaysure/resources/js/private/renewal/medicalDeclaration.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("/mystaysure/amend-renewal-medical-details-agree")
        .post("/mystaysure/amend-renewal-medical-details-agree")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("id", "2430")
        .formParam("auth", "93b0b5ab038e0474e5b14e889a26a2a1dadc5ecb3fe4affd30279219b17bbffc")
    )
    .pause(3)
    .exec(
      http("/mystaysure/amend-renewal-medical-details-continue")
        .post("/mystaysure/amend-renewal-medical-details-continue")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("id", "2430")
        .formParam("auth", "93b0b5ab038e0474e5b14e889a26a2a1dadc5ecb3fe4affd30279219b17bbffc")
        .formParam("travelInformationDTO.quoteTravelers[0].hasMedicalCondition", "Y")
        .formParam("travelInformationDTO.quoteTravelers[0].id", "2863")
        .resources(
          http("request_25")
            .get("/mystaysure/resources/js/private/renewal/policyDetails.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("/mystaysure/amend-renewal-policy-details")
        .post("/mystaysure/amend-renewal-policy-details")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("id", "2430")
        .formParam("isAcoChanged", "false")
        .formParam("isSamePageRedirection", "false")
        .formParam("auth", "93b0b5ab038e0474e5b14e889a26a2a1dadc5ecb3fe4affd30279219b17bbffc")
        .formParam("travelInformationDTO.policyPackage", "COMPREHENSIVE")
        .formParam("myAccRenewalInfoDTO.selectedCancellationCoverValue", "5000")
        .formParam("quoteResultDTO.upgradeCoverLimitDTOs[0].value", "500")
        .formParam("optionalExtras[0].code", "FCO_ADVICE")
        .formParam("optionalExtras[0].removedBySystem", "false")
        .formParam("optionalExtras[0].value", "")
        .formParam("optionalExtras[1].code", "EXCESS_WAIVER")
        .formParam("optionalExtras[1].removedBySystem", "false")
        .formParam("optionalExtras[1].value", "")
        .formParam("optionalExtras[2].code", "TDE")
        .formParam("optionalExtras[2].removedBySystem", "false")
        .formParam("optionalExtras[2].value", "")
        .formParam("optionalExtras[3].code", "CRUISE_COVER")
        .formParam("optionalExtras[3].removedBySystem", "false")
        .formParam("optionalExtras[3].value", "")
        .formParam("optionalExtras[4].code", "GADGET_COVER")
        .formParam("optionalExtras[4].removedBySystem", "false")
        .formParam("optionalExtras[4].value", "")
        .formParam("optionalExtras[4].selected", "on")
        .formParam("optionalExtras[5].code", "WINTER_SPORTS_COVER")
        .formParam("optionalExtras[5].removedBySystem", "false")
        .formParam("optionalExtras[5].value", "")
        .formParam("optionalExtras[6].code", "HUNDRED_DAYS_DURATION")
        .formParam("optionalExtras[6].removedBySystem", "false")
        .formParam("optionalExtras[6].value", "")
        .formParam("optionalExtras[6].selected", "on")
        .formParam("optionalExtras[7].code", "CAR_HIRE_EXCESS_WAIVER")
        .formParam("optionalExtras[7].removedBySystem", "false")
        .formParam("optionalExtras[7].value", "")
        .formParam("optionalExtras[8].code", "SINGLE_ITEM_COVER")
        .formParam("optionalExtras[8].removedBySystem", "false")
        .formParam("optionalExtras[8].value", "")
        .formParam("optionalExtras[9].code", "GOLF_EQUIPMENT")
        .formParam("optionalExtras[9].removedBySystem", "false")
        .formParam("optionalExtras[9].value", "")
        .formParam("optionalExtras[10].code", "PERSONAL_LIABILITY_COVER")
        .formParam("optionalExtras[10].removedBySystem", "false")
        .formParam("optionalExtras[10].value", "")
        .resources(
          http("request_27")
            .get("/mystaysure/resources/js/private/renewal/summary.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("/mystaysure/confirm-summary-details")
        .post("/mystaysure/confirm-summary-details")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("id", "2430")
        .formParam("auth", "93b0b5ab038e0474e5b14e889a26a2a1dadc5ecb3fe4affd30279219b17bbffc")
        .formParam("isSamePageRedirection", "false")
        .formParam("paymentDetailDTO.optOutAutoRenewal", "false")
        .formParam("paymentDetailDTO.quoteDocumentRequestDTO.postageType", "0")
        .resources(
          http("request_29")
            .get("/mystaysure/resources/js/private/renewal/payment.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(6)
    .exec(
      http("/mystaysure/renewal-payment")
        .post("/mystaysure/renewal-payment")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("paymentDetailDTO.confirmMtaChanges", "<table class=\"table table-striped \" border='1'><caption>Travel Details</caption><tr><th><b>Record</b></th><th><b>Previous Value</b></th><th><b>New Value</b></th></tr><tr><td> Start Date</td><td>31/08/2021</td><td>31/08/2022</td></tr><tr><td> Policy End Date</td><td>30/08/2022</td><td>30/08/2023</td></tr></table><br><table class=\"table table-striped \" border='1'><caption>Traveler Details: Miss Fd Sdfd</caption><tr><th><b>Record</b></th><th><b>Previous Value</b></th><th><b>New Value</b></th></tr><tr><td> Age</td><td>29</td><td>30</td></tr></table><br>")
        .formParam("id", "2430")
        .formParam("auth", "93b0b5ab038e0474e5b14e889a26a2a1dadc5ecb3fe4affd30279219b17bbffc")
        .formParam("myAccRenewalInfoDTO.selectedRenewalOption", "PAY_FULL_BY_AUTO_RENEWAL")
        .formParam("paymentDetailDTO.agreeKeyFactAndTOB", "on")
        .formParam("paymentDetailDTO.promoCode", "")
        .formParam("paymentDetailDTO.agreeTermsAndConditions", "on")
        .resources(
          http("request_31")
            .get("/mystaysure/resources/images/email-sent-icon.svg")
            .headers(headers_6),
          http("request_32")
            .get("/mystaysure/resources/js/private/amendPolicy.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(2)
    .exec(
      http("/mystaysure/amend-personal-details")
        .post("/mystaysure/amend-personal-details")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("id", "2459")
        .formParam("auth", "0d7ea013759764ee82a2bfdfc45eed24b08212b0f687b9e20a4cc9c4bab24283")
        .formParam("organiserDTO.title", "Miss")
        .formParam("dob", "01/01/1992")
        .formParam("organiserDTO.email", "randisajani@intervest.lk")
        .formParam("organiserDTO.dayTimeTelephone", "0712617753")
        .formParam("organiserDTO.postcode", "NN47YB")
        .formParam("organiserDTO.address1", "Britannia House")
        .formParam("organiserDTO.address2", "Rushmills")
        .formParam("organiserDTO.city", "Northampton")
        .formParam("organiserDTO.county", "")
        .formParam("travelInformationDTO.quoteTravelers[0].sequence", "1")
        .formParam("travelInformationDTO.quoteTravelers[0].title", "Miss")
        .formParam("travelInformationDTO.quoteTravelers[0].firstName", "Fd")
        .formParam("travelInformationDTO.quoteTravelers[0].lastName", "Sdfd")
        .formParam("travelInformationDTO.quoteTravelers[0].age", "29")
        .formParam("paymentDetailDTO.errorMessage", "")
        .resources(
          http("request_34")
            .get("/mystaysure/resources/css/public/jquery-ui.min.css?relversion=4.9.0.1")
            .headers(headers_1),
          http("request_35")
            .get("/mystaysure/resources/js/private/amend/tripDetails.js?relversion=4.9.0.1")
            .headers(headers_2),
          http("request_36")
            .get("/mystaysure/resources/images/icon-calendar.svg")
            .headers(headers_6)
        )
    )
    .pause(3)
    .exec(
      http("/mystaysure/amend-policy")
        .get("/mystaysure/amend-policy?auth=0d7ea013759764ee82a2bfdfc45eed24b08212b0f687b9e20a4cc9c4bab24283&amendTabId=3")
        .headers(headers_13)
        .resources(
          http("request_38")
            .get("/mystaysure/resources/js/private/amend/medicalDeclaration.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("/mystaysure/amend-medical-details-agree")
        .post("/mystaysure/amend-medical-details-agree")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("id", "2459")
        .formParam("auth", "0d7ea013759764ee82a2bfdfc45eed24b08212b0f687b9e20a4cc9c4bab24283")
    )
    .pause(1)
    .exec(
      http("/mystaysure/amend-medical-details-continue")
        .post("/mystaysure/amend-medical-details-continue")
        .headers(headers_10)
        .formParam("_csrf", "ca8ba685-6fa7-4c68-aca3-12772d45be7a")
        .formParam("id", "2459")
        .formParam("auth", "0d7ea013759764ee82a2bfdfc45eed24b08212b0f687b9e20a4cc9c4bab24283")
        .resources(
          http("request_41")
            .get("/mystaysure/resources/js/private/amend/additionalCoverOptions.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("/mystaysure/amend-policy")
        .get("/mystaysure/amend-policy?auth=0d7ea013759764ee82a2bfdfc45eed24b08212b0f687b9e20a4cc9c4bab24283&amendTabId=5")
        .headers(headers_13)
        .resources(
          http("request_43")
            .get("/mystaysure/resources/js/private/amend/summary.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    )
    .pause(1)
    .exec(
      http("/mystaysure/amend-policy")
        .get("/mystaysure/amend-policy?auth=0d7ea013759764ee82a2bfdfc45eed24b08212b0f687b9e20a4cc9c4bab24283&amendTabId=6")
        .headers(headers_13)
        .resources(
          http("request_45")
            .get("/mystaysure/resources/js/private/amend/payment.js?relversion=4.9.0.1")
            .headers(headers_2)
        )
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
