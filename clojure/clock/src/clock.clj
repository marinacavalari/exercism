(ns clock
  (:require [clojure.string :as string]))

(defn clock->string [{:keys [hours minutes]}]
  (format "%02d:%02d" hours minutes))

(defn clock [hours minutes]
  (let [hours-to-add (/ minutes 60)]
    {:hours (int (Math/floor (mod (+ hours-to-add hours) 24)))
     :minutes (mod minutes 60)}))

(defn add-time [{:keys [hours minutes]} time] ;; <- arglist goes here
  (let [new-minutes (+ minutes time)
        hours-to-add (/ (+ new-minutes) 60)]
    {:hours (int (Math/floor (mod (+ hours-to-add hours) 24)))
     :minutes (mod new-minutes 60)}))
