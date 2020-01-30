(ns status-im.ui.screens.routing.intro-login-stack
  (:require [status-im.utils.config :as config]))

(def login-stack
  {:screens (cond-> [:login
                     :multiaccounts
                     :intro-wizard
                     :progress
                     :keycard-recovery-intro
                     :create-multiaccount
                     :create-multiaccount-generate-key
                     :create-multiaccount-choose-key
                     :create-multiaccount-select-key-storage
                     :create-multiaccount-create-code
                     :create-multiaccount-confirm-code
                     :recover-multiaccount-enter-phrase
                     :recover-multiaccount-select-storage
                     :recover-multiaccount-enter-password
                     :recover-multiaccount-confirm-password
                     :recover-multiaccount-success]

              config/hardwallet-enabled?
              (concat [:hardwallet-authentication-method
                       :hardwallet-connect
                       :keycard-login-pin
                       :keycard-login-connect-card
                       :keycard-nfc-on
                       :keycard-blank
                       :keycard-wrong
                       :keycard-unpaired
                       :not-keycard]))})

(def intro-stack
  (-> login-stack
      (update :screens conj
              :intro
              :intro-wizard
              :keycard-connection-lost
              :keycard-connection-lost-setup
              :keycard-nfc-on
              :keycard-pairing
              :keycard-onboarding-intro
              :keycard-onboarding-start
              :keycard-onboarding-puk-code
              :keycard-onboarding-preparing
              :keycard-onboarding-finishing
              :keycard-onboarding-pin
              :keycard-onboarding-recovery-phrase
              :keycard-onboarding-recovery-phrase-confirm-word1
              :keycard-onboarding-recovery-phrase-confirm-word2
              :keycard-recovery-intro
              :keycard-recovery-start
              :keycard-recovery-pair
              :keycard-recovery-recovering
              :keycard-recovery-success
              :keycard-recovery-no-key
              :keycard-recovery-pin)
      (assoc :name :intro-stack)
      (assoc :config {:initialRouteName :progress})))
