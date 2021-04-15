(ns bob 
  (:require [clojure.string :as str]))

(def question "Sure.")
(def fine "Fine. Be that way!")
(def yell "Whoa, chill out!")
(def whatever  "Whatever.")
(def forceful-questions "Calm down, I know what I'm doing!")

(defn response-for [phrase]
  (let [letters (filter #(Character/isLetter %) phrase)
        question? (= (last (str/trimr phrase)) \?)
        all-letters-upcase? (and (seq letters)
                                 (every? #(Character/isUpperCase %) letters))]
   (cond
     (str/blank? phrase) fine
     (and question? all-letters-upcase?) forceful-questions
     question? question
     all-letters-upcase? yell
     :else whatever)))