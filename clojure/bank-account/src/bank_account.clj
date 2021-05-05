(ns bank-account)

(defn open-account []
 (atom  {:balance 0
         :state :active}))

(defn close-account [account]
  (reset! account (atom {})))

(defn get-balance [account]
  (:balance @account))

(defn update-balance [account new-balance]
  (swap! account update :balance + new-balance))

