## [2.54.1] - 2025-07-28

### Added

- `Sku` parameter on LineItem, for [Klarna PayIns](https://docs.mangopay.com/api-reference/klarna/create-klarna-payin)
- support for new
  endpoint [View supported banks for Pay by Bank](https://docs.mangopay.com/api-reference/pay-by-bank/view-supported-banks-pay-by-bank),
  to enable presentation of banks to user before Pay by Bank payment request

## [2.54.0] - 2025-07-18

### Added

Endpoints for [Mangopay Echo](https://docs.mangopay.com/guides/echo), a solution for platforms working with another
third-party PSP for funds acquisition (including via the Mirakl Connector) #413 :

- [POST Create an Intent](https://docs.mangopay.com/api-reference/intents/create-intent)
- [GET View an Intent](https://docs.mangopay.com/api-reference/intents/view-intent)
- [POST Create a Capture for an Intent](https://docs.mangopay.com/api-reference/intents/create-intent-capture)
- [POST Create a Settlement](https://docs.mangopay.com/api-reference/settlements/create-settlement)
- [PUT Update a Settlement](https://docs.mangopay.com/api-reference/settlements/update-settlement)
- [GET View a Settlement](https://docs.mangopay.com/api-reference/settlements/view-settlement)
- [POST Create a Split of an Intent](https://docs.mangopay.com/api-reference/intents/create-intent-split)

## [2.53.0] - 2025-06-24

### Changed

- Minimum language version changed to **Java 8.0 or higher**
- Java `sourceCompatibility` changed to **1.8** (#392)
- README updated

### Added

- New endpoint [POST Create a Bizum PayIn](https://docs.mangopay.com/api-reference/bizum/create-bizum-payin) (#412)
- New webhook event types for SCA enrollment – API release planned for Monday, note that these are triggered on
  enrollment not authentication (#414):
  - `SCA_ENROLLMENT_SUCCEEDED`
  - `SCA_ENROLLMENT_FAILED`
  - `SCA_ENROLLMENT_EXPIRED`
- New webhook event types for `UserCategory` change – API release planned for Monday (#414):
  - `USER_CATEGORY_UPDATED_TO_OWNER`
  - `USER_CATEGORY_UPDATED_TO_PAYER`
  - `USER_CATEGORY_UPDATED_TO_PLATFORM`
- Support for `PLATFORM` value to `UserCategory` enum (thank you @AntoineDuComptoirDesPharmacies #401)

## [2.52.2] - 2025-06-12
### Updated

- release configurations

## [2.52.1] - 2025-06-12

### Added
- [US and CA virtual accounts](https://docs.mangopay.com/release-notes/api/2025-06-12) for local pay-in collection
- [GET List Transactions for a Card Fingerprint](https://docs.mangopay.com/api-reference/transactions/list-transactions-card-fingerprint#list-transactions-for-a-card-fingerprint)

## [2.52.0] - 2025-06-10

### Added

Endpoints for [new Reporting Service](https://docs.mangopay.com/release-notes/api/2025-06-05) feature:

- [POST Create a Report](https://docs.mangopay.com/api-reference/reporting/create-report)
- [GET View a Report](https://docs.mangopay.com/api-reference/reporting/view-report)
- [GET List all Reports](https://docs.mangopay.com/api-reference/reporting/list-reports)

Webhook [event types](url) for new Reporting Service:

- `REPORT_GENERATED`
- `REPORT_FAILED`

## [2.51.1] - 2025-06-06

### Added

- Support for `RecipientScope` query parameter
  on [GET List Recipients for a User](https://docs.mangopay.com/api-reference/recipients/list-recipients-user)
- [POST Validate the format of User data](https://docs.mangopay.com/api-reference/user-data-format/validate-user-data-format)
- [GET List Disputes for a PayIn](https://docs.mangopay.com/api-reference/disputes/list-disputes-payin)

### Fixed

- `Status` enum value on Identity Verification object changed from `OUTDATED` to `OUT_OF_DATE`

## [2.51.0] - 2025-05-23

### Added

Event types for [user account webhooks](https://docs.mangopay.com//webhooks/event-types#user-account), relevant
to [SCA enrollment in user endpoints](https://docs.mangopay.com/guides/sca/users#user-status) and account closure:

- `USER_ACCOUNT_VALIDATION_ASKED`
- `USER_ACCOUNT_ACTIVATED`
- `USER_ACCOUNT_CLOSED`

Event types for [instant and quoted FX conversions](https://docs.mangopay.com//webhooks/event-types#fx-conversions):

- `INSTANT_CONVERSION_CREATED`
- `INSTANT_CONVERSION_SUCCEEDED`
- `INSTANT_CONVERSION_FAILED`
- `QUOTED_CONVERSION_CREATED`
- `QUOTED_CONVERSION_SUCCEEDED`
- `QUOTED_CONVERSION_FAILED`

Support
for [30-day deposit preauthorization](https://docs.mangopay.com/guides/payment-methods/card/deposit-preauthorization)
features:

- [POST Create a Deposit Preauthorized PayIn prior to complement](https://docs.mangopay.com/api-reference/deposit-preauthorizations/create-deposit-preauthorized-payin-prior-to-complement)
- [POST Create a Deposit Preauthorized PayIn complement](https://docs.mangopay.com/api-reference/deposit-preauthorizations/create-deposit-preauthorized-payin-complement)
- `NO_SHOW_REQUESTED` on `updateDeposit` method
  for [PUT Cancel a Deposit Preauthorization or request a no-show](https://docs.mangopay.com/api-reference/deposit-preauthorizations/cancel-deposit-preauthorization-request-no-show)
- [GET View a PayIn (Deposit Preauthorized Card](https://docs.mangopay.com/api-reference/deposit-preauthorizations/view-payin-deposit-preauthorized)
- [GET List Transactions for a Deposit Preauthorization](https://docs.mangopay.com/api-reference/transactions/list-transactions-deposit-preauthorization)

## [2.50.0] - 2025-05-14

### Added and refined

#### Hosted KYC/KYB endpoints

The following endpoints have been refined following the beta phase, and are now generally available:

- [POST Create an IDV Session](https://docs.mangopay.com/api-reference/idv-sessions/create-idv-session) (no changes)
- [GET View an IDV Session](https://docs.mangopay.com/api-reference/idv-sessions/view-idv-session) (includes `Checks` in
  response)
- [GET List IDV Sessions for a User](https://docs.mangopay.com/api-reference/idv-sessions/list-idv-sessions-user) (new
  endpoint)

The previously available endpoint GET View Checks for an IDV Session has been removed (as Checks were integrated into
the GET by ID).

See the [guide](https://docs.mangopay.com/guides/users/verification/hosted) for more details.

#### Recipients

The `Country` property has been added to [Recipients](https://docs.mangopay.com/guides/sca/recipients), as a required
query parameter
on [GET View the schema for a Recipient](https://docs.mangopay.com/api-reference/recipients/view-recipient-schema) and
as a required body parameter
on [POST Validate data for a Recipient](https://docs.mangopay.com/api-reference/recipients/validate-recipient-data)
and [POST Create a Recipient](https://docs.mangopay.com/api-reference/recipients/create-recipient).

### Added

- [GET List Deposit Preauthorizations for a Card](https://docs.mangopay.com/api-reference/deposit-preauthorizations/list-deposit-preauthorizations-card)
- [GET List Deposit Preauthorizations for a User](https://docs.mangopay.com/api-reference/deposit-preauthorizations/list-deposit-preauthorizations-user)

## [2.49.0] - 2025-04-29

### Added

#### SCA on wallet access endpoints

`ScaContext` query parameter added on wallet access endpoints for
the [introduction of SCA](https://docs.mangopay.com/guides/sca/wallets):

- [GET View a Wallet](https://docs.mangopay.com/api-reference/wallets/view-wallet)
- [GET List Wallets for a User](https://docs.mangopay.com/api-reference/wallets/list-wallets-user)
- [GET List Transactions for a User](https://docs.mangopay.com/api-reference/transactions/list-transactions-user)
- [GET List Transactions for a Wallet](https://docs.mangopay.com/api-reference/transactions/list-transactions-wallet)

If SCA is required, Mangopay responds with a 401 response code. The `PendingUserAction` `RedirectUrl` is in the
dedicated `WWW-Authenticate` response header.

See the tests for examples on handling this error.

## [2.48.0] - 2025-04-24

### Added

#### Recipients

- [GET View payout methods](/api-reference/recipients/view-payout-methods)
- [GET View the schema for a Recipient](/api-reference/recipients/view-recipient-schema)
- [POST Validate data for a Recipient](/api-reference/recipients/validate-recipient-data)
- [POST Create a Recipient](/api-reference/recipients/create-recipient)
- [GET View a Recipient](/api-reference/recipients/view-recipient)
- [GET List Recipients for a user](/api-reference/recipients/list-recipients-user)
- [PUT Deactivate a Recipient](/api-reference/recipients/deactivate-recipient)
- Webhook event types:
  - `RECIPIENT_ACTIVE`
  - `RECIPIENT_CANCELED`
  - `RECIPIENT_DEACTIVATED`

#### SCA on Owner-initiated transfers

- On [POST Create a Transfer](/api-reference/transfers/create-transfer)
  - `ScaContext` body parameter
  - `PendingUserAction` response field containing `RedirectUrl`

#### Endpoints to close a user account

- [DELETE Close a Natural User](/api-reference/users/close-natural-user)
- [DELETE Close a Legal User](/api-reference/users/close-legal-user)

## [2.47.0] - 2025-04-24

### Added

- [POST Create a Swish PayIn](https://docs.mangopay.com/api-reference/swish/create-swish-payin)
- [POST Create a Pay by Bank PayIn](https://docs.mangopay.com/api-reference/pay-by-bank/create-pay-by-bank-payin),
  including related `PAYIN_NORMAL_PROCESSING_STATUS_PENDING_SUCCEEDED` webhook event type
- `RTGS_PAYMENT` for `PayoutModeRequested`
  on [POST Create a Payout](https://docs.mangopay.com/api-reference/payouts/create-payout)
- PayPal recurring payments, thanks to the `PaymentType` value `PAYPAL`
  on [Recurring PayIn Registrations](https://docs.mangopay.com/api-reference/recurring-payin-registrations/create-recurring-payin-registration-paypal)
  and new
  endpoints ([POST Create a Recurring PayPal PayIn (CIT)](https://docs.mangopay.com/api-reference/paypal/create-recurring-paypal-payin-cit)
  and [POST Create a Recurring PayPal PayIn (MIT)](https://docs.mangopay.com/api-reference/paypal/create-recurring-paypal-payin-mit)

## [2.46.0] - 2025-04-01

### Changed

- User-Agent Header value standardized on format: User-Agent: Mangopay-SDK/`SDKVersion` (`Language`/`LanguageVersion`)

### Fixed

- Replaced int property with Money property for recurring payin registration `TotalAmount`
- Fixed tests for categorize SCA users endpoint

### Added

- Support
  for [POST Create a BLIK PayIn (with code)](https://docs.mangopay.com/api-reference/blik/create-blik-payin-with-code)

## [2.45.0] - 2025-03-07

### Added

New endpoint for [strong customer authentication (SCA)](https://docs.mangopay.com/guides/users/sca) on Owner users:

- [POST Enroll a User in SCA](https://docs.mangopay.com/api-reference/users/enroll-user)

### Added

New endpoint for Payconiq:

- [POST Create a Payconiq PayIn](https://docs.mangopay.com/api-reference/payconiq/create-payconiq-payin)

## [2.44.3] - 2025-02-28

### Fixed

Added missing timeout config for doRequestList()

## [2.44.2] - 2025-02-26

### Fixed

Rate limiting headers interpreted dynamically based on `X-RateLimit-Reset` time and for a variable number of bucket
values.

## [2.44.1] - 2025-02-11

### Fixed

Added a custom deserializer to support the `CardInfo.Type` naming change from `CHARDE_CARD` to `CHARGE CARD`.

## [2.44.0] - 2025-02-10

### Added

New endpoints for [TWINT PayIn](https://docs.mangopay.com/api-reference/twint/twint-payin-object) object:

- [Create a TWINT PayIn](https://docs.mangopay.com/api-reference/twint/create-twint-payin)
- [View a PayIn (TWINT)](https://docs.mangopay.com/api-reference/twint/view-payin-twint)

### Updated

- Removed the `Reference` parameter from the [Refund](https://docs.mangopay.com/api-reference/refunds/refund-object)
  object.
- Added additional tests for transaction retrieval.

## [2.43.0] - 2025-02-07

### Added

New endpoints
for [hosted Identity Verification](https://docs.mangopay.com/guides/users/verification/hosted#guide-to-hosted-identity-verification):

- [Create a hosted Identity Verification Session](https://docs.mangopay.com/guides/users/verification/hosted#post-create-a-hosted-identity-verification-session)
- [View an Identity Verification Session](https://docs.mangopay.com/guides/users/verification/hosted#get-view-an-identity-verification-session)
- [View an Identity Verification Checks](https://docs.mangopay.com/guides/users/verification/hosted#get-view-identity-verification-checks)

## [2.42.2] - 2025-02-04

### Updated

- Revised tests to improve reliability and address any outdated tests.
- Added instant payout event `INSTANT_PAYOUT_FAILED`.

## [2.42.1] - 2025-01-23
### Fixed

The [Categorize a Natural User](https://docs.mangopay.com/api-reference/users/categorize-natural-user) endpoint now allows non-SCA users to be categorized as SCA users.

## [2.42.0] - 2025-01-17
### Added
New endpoints for strong customer authentication (SCA):

- POST Create a Natural User (SCA)
- PUT Update a Natural User (SCA)
- POST Create a Legal User (SCA)
- PUT Update a Legal User (SCA)
- PUT Categorize a Natural User (SCA)
- PUT Categorize a Legal User (SCA)
- POST Activate a User (SCA)

## [2.41.1] - 2025-01-09
### Fixed
#345 `PayInReferences` class attributes are now readable and instantiable. Thank you for your contribution [@toni07 ](https://github.com/toni07)!

## [2.41.0] - 2024-12-25
### Added

New endpoints for The Virtual Account object:

- Create a Virtual Account
- Deactivate a Virtual Account
- View a Virtual Account
- List Virtual Accounts for a Wallet
- View Client Availabilities

Added all relevant `EVENT_TYPE_CHOICES`:

- `VIRTUAL_ACCOUNT_ACTIVE`
- `VIRTUAL_ACCOUNT_BLOCKED`
- `VIRTUAL_ACCOUNT_CLOSED`
- `VIRTUAL_ACCOUNT_FAILED`

## [2.40.0] - 2024-12-17
### Added

- New `TransactionDetails` parameter for [Bank wire PayIns](https://docs.mangopay.com/api-reference/bank-wire-payins/bank-wire-payin-object).

## [2.39.0] - 2024-12-13
### Added

- New `PaymentRef` parameter for [Payouts](https://docs.mangopay.com/api-reference/payouts/payout-object#the-payout-object)

## [2.38.2] - 2024-09-04
### Fixed

- Add additional refund reason types.

## [2.38.1] - 2024-08-26
### Fixed
- Fixed the idempotency source URL ID pattern matcher to support the updated resource ID format. (thank you @AntoineDuComptoirDesPharmacies )

## [2.38.0] - 2024-08-07
### Added

1. New endpoint: [Create a Bancontact PayIn](https://docs.mangopay.com/api-reference/bancontact/bancontact-payin-object#create-bancontact-payin)
2. New parameter `PaymentCategory` for the following endpoints:
- [Create a Card Validation](https://docs.mangopay.com/api-reference/card-validations/create-card-validation)
- [Create a Direct Card PayIn](https://docs.mangopay.com/api-reference/direct-card-payins/create-direct-card-payin)
- [Create a Preauthorization](https://docs.mangopay.com/api-reference/preauthorizations/create-preauthorization)
3. New parameter `StatementDescriptor` for the following endpoints:
- [Create a Refund for a PayIn](https://docs.mangopay.com/api-reference/refunds/create-refund-payin)
- [View a Refund](https://docs.mangopay.com/api-reference/refunds/view-refund)

### Fixed

- Adjust the parameter `CardHolderName`

## [2.37.2] - 2024-05-24
### Added

- New parameter `CardHolderName` for [Update Card registration](https://mangopay.com/docs/endpoints/card-validations#update-card-registration)

## [2.37.1] - 2024-04-30
### Fixed

- Updated the implementation for [Look up metadata for a payment method](https://mangopay.com/docs/endpoints/payment-method-metadata#lookup-payment-method-metadata). The `CommercialIndicator` and `CardType` fields have been moved to the `BinData` object in the API response.

## [2.37.0] - 2024-04-02
### Added

- New endpoint [Add tracking to Paypal payin](https://mangopay.com/docs/endpoints/paypal#add-tracking-paypal-payin)
- New parameter `SecureMode` for [Create card validation](https://mangopay.com/docs/endpoints/card-validations#create-card-validation)
- New parameters for PayPal mean of payment : `CancelURL` & `Category` (sub-parameter of `LineItems`). And management of `PaypalPayerID`, `BuyerCountry`, `BuyerFirstname`, `BuyerLastname`, `BuyerPhone`, `PaypalOrderID` in the response.

## [2.36.0] - 2024-03-08
### Fixed

- Fixed incorrect spelling of the `Subtype` key in the `BinData` parameter.
- Conversions endpoint spelling

### Added

- The optional Fees parameter is now available on instant conversions, allowing platforms to charge users for FX services. More information [here](https://mangopay.com/docs/release-notes/millefeuille).
- Platforms can now use a quote to secure the rate for a conversion between two currencies for a set amount of time. More information [here](https://mangopay.com/docs/release-notes/millefeuille).
- Introduced the `isUkHeaderFlag` boolean configuration key. Platforms partnered with Mangopay's UK entity should set this key to true for proper configuration.

## [2.35.1] - 2024-02-16
### Fixed

- Naming of Get card validation endpoint switch to : getCardValidation()

## [2.35.0] - 2024-02-06
### Added

- New endpoint to look up metadata from BIN or Google Pay token. More information [here](https://mangopay.com/docs/release-notes/kisale)
- [Get a card validation endpoint](https://mangopay.com/docs/endpoints/card-validations#view-card-validation)

### Fixed
- `setCardApi` is now `public` in `com.mangopay.MangoPayApi` #316

## [2.34.0] - 2023-12-22
### Added

New `CardInfo` parameter returned on card transactions. More information [here](https://mangopay.com/docs/release-notes/chilka).

## [2.33.0] - 2023-12-07
### Added

The IDEAL legacy implementation has been enhanced. You can now pass the Bic., and if provided, the API response will include the BankName parameter. More information here.

## [2.32.1] - 2023-11-09
### Added

It's now possible to specify an amount for DebitedFunds and Fees when you create a refund with `getPayInApi().createRefund()`.

## [2.32.0] - 2023-11-02
### Updated
- Giropay and Ideal integrations with Mangopay have been improved.
- Klarna param "MerchantOrderId" has been renamed to "Reference"

### Added
- New Reference parameter for the new Paypal implementation.

## [2.31.0] - 2023-09-29
### Added

- Multibanco, Satispay, Blik, Klarna are now available as a payment method with Mangopay. This payment method is in private beta. Please contact support if you have any questions.
- Card validation endpoint is now available (Private beta)
- A new parameter for Paypal : ShippingPreference
- Instantly convert funds between 2 wallets of different currencies owned by the same user with the new SPOT FX endpoints

### Updated

- Google Pay integration with Mangopay has been improved. This payment method is in private beta. Please contact support if you have any questions.

### Fixed

- MBWay & PayPal are now using Web Execution Type.

## [2.30.0] - 2023-07-28
### Added

Paypal integration with Mangopay has been improved. This payment method is in private beta. Please contact support if you have any questions.

## [2.29.1] - 2023-07-07
### Fixed

- `Phone` parameter instead of `PhoneNumber` for MBWay

## [2.29.0] - 2023-06-21
### Added

- MB WAY is now available as a payment method with Mangopay. This payment method is in private beta. Please contact support if you have any questions.

## [2.28.0] - 2023-03-17
### Added

Knowing when a dispute was closed is now possible thanks to the new ClosedDate parameter for the Dispute object.

The following endpoints have been updated accordingly:

[Vew a Dispute](ttps://docs.mangopay.com/endpoints/v2.01/disputes#e240_view-a-dispute)

[List Disputes for a User](https://docs.mangopay.com/endpoints/v2.01/disputes#e817_list-a-users-disputes)

[List Disputes for a Wallet](https://docs.mangopay.com/endpoints/v2.01/disputes#e816_list-a-wallets-disputes)

[List all Disputes](https://docs.mangopay.com/endpoints/v2.01/disputes#e241_list-all-disputes)

[List Disputes that need settling](https://docs.mangopay.com/endpoints/v2.01/disputes#e980_list-disputes-that-need-settling)

Please note that the new ClosedDate field will only display values for the Disputes closed after this release. Otherwise, a null value will be returned.

## [2.27.2] - 2023-03-03
### Fixed

- #290 Missing Kosovo in CountryISO enum

## [2.27.1] - 2023-01-26
### Fixed

- Fix bug preventing access to authentication endpoint

## [2.27.0] - 2023-01-12
### Added

Verifying some specific legal structures is now more efficient thanks to a new legal entity type: `PARTNERSHIP`.

The Legal User LegalPersonType parameter now includes the `PARTNERSHIP` value. The following endpoints have been updated accordingly:

[Create a Legal User (Payer)](https://docs.mangopay.com/endpoints/v2.01/users#e259_create-a-legal-user)

[Create a Legal User (Owner)](https://docs.mangopay.com/endpoints/v2.01/users#e1060_create-a-legal-user-owner)

[Update a Legal User](https://docs.mangopay.com/endpoints/v2.01/users#e261_update-a-legal-user)

Please note that changing the LegalPersonType to `PARTNERSHIP` for an existing user will automatically result in:

- A KYC downgrade to Light (default) verification
- The REGISTRATION_PROOF document being flagged as OUT_OF_DATE.

With this new LegalPersonType, the MANGOPAY team can better handle specific legal structures and speed up the validation process.



## [2.26.0] - 2022-12-20
### Added

#### New 30-day preauthorization feature

Preauthorizations can now hold funds for up to 30 days, therefore ensuring the solvency of a registered card for the same amount of time.

- The **DepositApi** service has been added with methods for creating, fetching and canceling a deposit
- The **Deposit** entity has been created
- The **createCardPreAuthorizedDepositPayIn** method has been added to the PayIn service

Thanks to 30-day preauthorizations, MANGOPAY can provide a simpler and more flexible payment experience for a wide range of use cases, especially for rentals.

#### New behavior when MANGOPAY API is down

- Instead of NPE when the API is down, a custom Exception has been added

## [2.25.2] - 2022-10-14
### Fixed

Tests have been fixed due to API evolution.

## [2.25.1] - 2022-09-16
### Fixed
User `TermsAndConditionsAccepted` is now nullable

## [2.25.0] - 2022-08-17
### Added
**New country authorizations endpoints**

Country authorizations can now be viewed by using one of the following endpoints:

<a href="https://docs.mangopay.com/endpoints/v2.01/regulatory#e1061_the-country-authorizations-object">View a country's authorizations</a> <br>
<a href="https://docs.mangopay.com/endpoints/v2.01/regulatory#e1061_the-country-authorizations-object">View all countries' authorizations</a>

With these calls, it is possible to check which countries have:

- Blocked user creation
- Blocked bank account creation
- Blocked payout creation

Please refer to the <a href="https://docs.mangopay.com/guide/restrictions-by-country">Restrictions by country</a>
article for more information.

## [2.24.0] - 2022-06-29
##Added
**Recurring: €0 deadlines for CIT**

Setting free recurring payment deadlines is now possible for CIT (customer-initiated transactions) with the **FreeCycles** parameter.

The **FreeCycles** parameter allows platforms to define the number of consecutive deadlines that will be free. The following endpoints have been updated to take into account this new parameter:

<a href="https://docs.mangopay.com/endpoints/v2.01/payins#e1051_create-a-recurring-payin-registration">Create a Recurring PayIn Registration</a><br>
<a href="https://docs.mangopay.com/endpoints/v2.01/payins#e1056_view-a-recurring-payin-registration">View a Recurring PayIn Registration</a><br>

This feature provides new automation capabilities for platforms with offers such as “Get the first month free” or “free trial” subscriptions.

Please refer to the <a href="https://docs.mangopay.com/guide/recurring-payments-introduction">Recurring payments overview</a> documentation for more information.

## [2.23.0] - 2022.05.24
### Added

#### UserCategory management

Users can now be differentiated depending on their MANGOPAY usage.

This is possible with the new UserCategory parameter, whose value can be set to:

- Payer – For users who are only using MANGOPAY to give money to other users (i.e., only pay).
- Owner – For users who are using MANGOPAY to receive funds (and who are therefore required to accept MANGOPAY’s terms and conditions).

Please note that the following parameters become required as soon as the UserCategory is set to “Owner”:
- HeadquartersAddress
- CompanyNumber (if the LegalPersonType is “Business”)
- TermsAndConditionsAccepted.

The documentation of user-related endpoints has been updated and reorganised to take into account the new parameter:

[Create a Natural User (Payer)](https://docs.mangopay.com/endpoints/v2.01/users#e255_create-a-natural-user)
[Create a Natural User (Owner)](https://docs.mangopay.com/endpoints/v2.01/users#e1059_create-natural-user-owner)
[Update a Natural User](https://docs.mangopay.com/endpoints/v2.01/users#e260_update-a-natural-user)
[Create a Legal User (Payer)](https://docs.mangopay.com/endpoints/v2.01/users#e259_create-a-legal-user)
[Create a Legal User (Owner)](https://docs.mangopay.com/endpoints/v2.01/users#e1060_create-a-legal-user-owner)
[Update a Legal User](https://docs.mangopay.com/endpoints/v2.01/users#e261_update-a-legal-user)
[View a User](https://docs.mangopay.com/endpoints/v2.01/users#e256_view-a-user)
[List all Users](https://docs.mangopay.com/endpoints/v2.01/users#e257_list-all-users)

Differentiating the platform users results in a smoother user experience for “Payers” as they will have less declarative data to provide.

## [2.22.0] - 2022.05.12
### Added

#### Terms and conditions acceptance parameter

The acceptance of the MANGOPAY terms and conditions by the end user can now be registered via the SDK.

This information can be managed by using the new `TermsAndConditionsAccepted` parameter added to the `User` object.

The following API endpoints have been updated to take into account the new TermsAndConditionsAccepted parameter:

[Create a Natural User](https://docs.mangopay.com/endpoints/v2.01/users#e255_create-a-natural-user)
[Update a Natural User](https://docs.mangopay.com/endpoints/v2.01/users#e260_update-a-natural-user)
[Create a Legal User](https://docs.mangopay.com/endpoints/v2.01/users#e259_create-a-legal-user)
[Update a Legal User](https://docs.mangopay.com/endpoints/v2.01/users#e261_update-a-legal-user)
[View a User](https://docs.mangopay.com/endpoints/v2.01/users#e256_view-a-user)

Please note that:

- Existing users have to be updated to include the terms and conditions acceptance information.
- Once accepted, the terms and conditions cannot be revoked.

## [2.21.0] - 2022.03.31
### Added

#### Instant payment eligibility check

With the function
`PayOutEligibilityResult checkInstantPayoutEligibility(String idempotencyKey, PayOutEligibility payOutEligibility);`
the destination bank reachability can now be verified prior to making an instant payout. This results in a better user experience, as this preliminary check will allow the platform to propose the instant payout option only to end users whose bank is eligible.

#### Instant payment mode only

Instant Payment requests can now be automatically cancelled when an issue is encountered (rather than falling back to the standard payout mode).

This is possible by using the new `INSTANT_PAYMENT_ONLY` option that has been added to the `PayoutModeRequested` parameter.

#### Tag on KYC Document creation

You can now add a tag while creating a KYC Document

### Fixed

- Issues with the BankAccount deserializer and IBAN and US account number
- missing debitedFunds and fees on class RecurringPayInMIT


## [2.20.0] - 2021-11-17
## Added

### Instant payouts hooks

We are now providing new hooks for our new feature [Instant payouts](https://docs.mangopay.com/guide/instant-payment-payout) :

- INSTANT_PAYOUT_SUCCEEDED
- INSTANT_PAYOUT_FALLBACKED

It will allow you to trigger an action depends on the Instant Payout treatment.

### GET a RecurringPayIn ID

You can now request the RecurringPayIn ID to check if the status is valid using
`this.api.getPayInApi().get(createdCit.getId())`

## [2.19.0] - 2021-10-20
## Added

You can now change the status to "ENDED" for a recurring payment.

## Fixed

- "Status" is now available in the response when you request a recurring payment registration.

## [2.18.0] - 2021-10-14
## Fixed

- Card deactivation
- UBO Declaration creation
- User-Agent in headers

## Added

### Payconiq

As requested by numerous clients, we are now providing [Payconiq](https://www.payconiq.be) as a new mean-of-payment. To request access, please contact MANGOPAY.

### Flags for KYC documents

**We provide more information regarding refused KYC documents.** Therefore it will be easier for you to adapt your app behavior and help your end user.

You are now able to see the exact explanation thanks to a new parameter called “Flags”.

It has been added to

` this.api.getKycDocumentApi().getKycDocument(kycDocument.getId());`

It will display one or several error codes that provide the reason(s) why your document validation has failed. These error codes description are available [here](https://docs.mangopay.com/guide/kyc-document).

## [2.17.0] - 2021-08-10
## Fixed

- Better error parsing (issue #244)
- Change `FallbackReason` parameter's type to object in PayOutPaymentDetailsBankWire

## Added

- You can now update and view a Recurring PayIn Registration object. To know more about this feature, please consult the documentation [here](https://docs.mangopay.com/guide/recurring-payments-introduction).
- To improve recurring payments, we have added new parameters for CIT : DebitedFunds & Fees. To know more about this feature, please consult the documentation [here](https://docs.mangopay.com/endpoints/v2.01/payins#e1053_create-a-recurring-payin-cit)

## [2.16.0] - 2021-06-10
## Added

We have added a new feature **[recurring payments](https://docs.mangopay.com/guide/recurring-payments)** dedicated to clients needing to charge a card repeatedly, such as subscriptions or payments installments.

You can start testing in sandbox, to help you define your workflow. This release provides the first elements of the full feature.

- [Create a Recurring PayIn Registration object](https://docs.mangopay.com/endpoints/v2.01/payins#e1051_create-a-recurring-payin-registration), containing all the information to define the recurring payment
- [Initiate your recurring payment flow](https://docs.mangopay.com/endpoints/v2.01/payins#e1053_create-a-recurring-payin-cit) with an authenticated transaction (CIT) using the Card Recurring PayIn endpoint
- [Continue your recurring payment flow](https://docs.mangopay.com/endpoints/v2.01/payins#e1054_create-a-recurring-payin-mit) with an non-authenticated transaction (MIT) using the Card Recurring PayIn endpoint

This feature is not yet available in production and you need to contact the Support team to request access.

## Fixed

- Missing "Culture" parameter in PreAuthorization

## [2.15.0] - 2021-05-27
## Added

### Instant payment

Mangopay introduces the instant payment mode. It allows payouts (transfer from wallet to user bank account) to be processed within 25 seconds, rather than the 48 hours for a standard payout.

You can now use this new type of payout with the Java SDK.

Example :

```java
PayOut getPayOut = this.api.getPayOutApi().getBankwire(payOut.getId());
// where payOut.getId() is the id of an existing payout
```

Please note that this feature must be authorized and activated by MANGOPAY. More information [here](https://docs.mangopay.com/guide/instant-payment-payout).

### List transactions for a mandate

The [endpoint](https://docs.mangopay.com/endpoints/v2.01/transactions#e993_list-transactions-for-a-mandate) to list all transactions linked to mandate has been added to the SDK.

## [2.14.0] - 2021-05-11
## Fixed

### IBAN for testing purposes

⚠️ **IBAN provided for testing purpose should never be used outside of a testing environement!**

More information about how to test payments, click [here](https://docs.mangopay.com/guide/testing-payments).

### Others

- LegalRepresentativeBirthday primitive Long fixed. Thanks @LeComptoirDesPharmacies

## Added

Some of you use a lot the [PreAuthorization](https://docs.mangopay.com/endpoints/v2.01/preauthorizations#e183_the-preauthorization-object) feature of our API. To make your life easier, we have added three new events :

- PREAUTHORIZATION_CREATED
- PREAUTHORIZATION_SUCCEEDED
- PREAUTHORIZATION_FAILED

The goal is to help you monitor a PreAuthorization with a [webhook](https://docs.mangopay.com/endpoints/v2.01/hooks#e246_the-hook-object).

*Example: If a PreAuthorization is desynchronized, when the status is updated, you will be able to know it.*

## [2.13.0] - 2021-03-25
## Added

### On demand feature for 3DSv2

> **This on-demand feature is for testing purposes only and will not be available in production**

#### Request

We've added a new parameter `Requested3DSVersion` (not mandatory) that allows you to choose between versions of 3DS protocols (managed by the parameter `SecureMode`). Two values are available:
* `V1`
* `V2_1`

If nothing is sent, the flow will be 3DS V1.

The `Requested3DSVersion` may be included on all calls to the following endpoints:
* `/preauthorizations/card/direct`
* `/payins/card/direct`

#### Response

In the API response, the `Requested3DSVersion` will show the value you requested:
* `V1`
* `V2_1`
* `null` – indicates that nothing was requested

The parameter `Applied3DSVersion` shows you the version of the 3DS protocol used. Two values are possible:
* `V1`
* `V2_1`

## [2.12.0] - 2021-02-19
- 3DS2 integration with Shipping and Billing objects, including FirstName and LastName fields
  The objects Billing and Shipping may be included on all calls to the following endpoints:
  - /preauthorizations/card/direct
  - /payins/card/direct
  - /payins/card/web
- Enable Instant Payment for payouts by adding a new parameter PayoutModeRequested on the following endpoint /payouts/bankwire
  - The new parameter PayoutModeRequested can take two differents values : "INSTANT_PAYMENT" or "STANDARD" (STANDARD = the way we procede normaly a payout request)
  - This new parameter is not mandatory and if empty or not present, the payout will be "STANDARD" by default
    Instant Payment is in beta all over Europe - SEPA region
## [2.11.6] - 2020-12-09
- Added 'Regulatory' endpoint to allow checks of User Block Status
- Added support for Regulatory -> Blocked Status Hooks

## [2.11.5] - 2020-09-25
- added test to cover issue
- added new method for PreAuthorization Transactions
- added methods for creating client bank accounts and client payouts

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

 