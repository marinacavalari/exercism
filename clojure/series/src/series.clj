(ns series
  [:require [clojure.string :as str]])

(defn slices [string length]
  (if (> length (count string))
    (subs string 0 length)
    [])
)

(slices "" 1)

