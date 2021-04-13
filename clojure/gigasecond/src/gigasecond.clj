(ns gigasecond)

(defn from [year month day] 
  (let [full-date (-> (java.time.LocalDate/of year month day)
            (.atStartOfDay)
            (.plusSeconds 1000000000))]
    [(.getYear full-date) (.getMonthValue full-date) (.getDayOfMonth full-date)]))

