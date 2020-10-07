## [2.11.4] - 2020-09-25
- Missing UserID added in UboDeclaration process
- New endpoint to support changes to Card Validation process (please listen out for product announcements)
- Testing added for added for RemainingFunds feature
- Improved gson support and minor fixes

## [2.11.3] - 2020-08-24
- As part of KYC improvements, we are adding OUT_OF_DATE as a enum for KYC documents
- Due to changes to the API we are no longer accepting connections with a TLS certificate of 1.1 or lower, this concerns in particular .NET frameworks 4.5 and earlier. This update applies a fix which forced the application to use TLS 1.2. (edited)
- Fixed port settings in setBaseUrl() for use of Mock API - #206
- ProcessedDate is now a long #170
- Modified function to reflect payinExecutionDetailsDirect #157
- Added binaryData as a parameter to resolve DisputeApi defect #195
- Enabled TLS v1.2 for Java 7

## [2.11.2] - 2020-08-11
- Fixed PayInDeserializer not setting the WireReference from the JSON response. 

## [2.11.1] - 2020-08-10
- New MultiCapture and RemainingFunds Parameters in Preauthorization object
- BankingAlias Object returned now fixed, returns complete info
- Fixed JsonNull In PayInDeserializer, thank you https://github.com/ptroc
- "User-agent" format in the headers changed, aligned to other assets

## [2.11.0] - 2020-07-10
- USER_KYC_REGULAR has been added as a new Event. Thanks to it, you are now able to know when all the needed KYCs for a user have been validated and its KYCLevel is updated.
- Release adds typing for EventType values KYC_OUTDATED USER_KYC_REGULAR and USER_KYC_LIGHT
- Bug Fix -> Serializing certain address fields, filtering bank accounts

## [2.10.1] - 2020-03-23
### Fixed
- Serialization issue has been fixed. `ExecutionDetails` property was wrongly sent on JSON request, `TemplateURLOptions` was not taken in account for Payin Web.

## [2.10.0] - 2020-03-19
### Added 
- `AccountNumber` property added for Payins `EXTERNAL_INSTRUCTION` (BankingAliases)
- GooglePay `Payin` methods are now available. More info about activation to come in the following weeks...
- `EXPIRED` Mandate Status and linked `MANDATE_EXPIRED` Event Type has been added, as this feature will be shortly supported for DirectDebit Payins. More info on our [docs](https://docs.mangopay.com/endpoints/v2.01/mandates#e230_the-mandate-object)
### Changed
- `PAYLINE`parameter for PayInTemplateURLOptions will be deprecated in the following weeks for Payin Web (especiallay for Payin Cards). `PAYLINEV2` parameter has been added to be used instead.

## [2.9.0]
### Added
- ApplePay `Payin` methods are now available. More info about activation to come in the following weeks...
- New `Dispute` reason type `COUNTERFEIT_PRODUCT` has been added.

## [2.8.1] - 2019-09-09
### Added
- `GetEmoney` method now supports year and month parameters. More info on our [docs](https://docs.mangopay.com/endpoints/v2.01/user-emoney#e895_view-a-users-emoney)
### Fixed
- Fix content-length issue on UBODeclaration submission
- Migration to GSON

## [2.8.0] - 2019-08-29
### Added
- new [`UBODelaration`](https://docs.mangopay.com/endpoints/v2.01/ubo-declarations#e1024_the-ubo-declaration-object) submission system
- `CompanyNumber` support for [Legal `Users`](https://docs.mangopay.com/endpoints/v2.01/users#e259_create-a-legal-user)
### Fixed
Travis CI integration has ben fixed and ensure fast & secure package publishing on maven.org again.

 
