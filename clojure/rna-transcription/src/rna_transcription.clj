(ns rna-transcription)

(defn to-rna [dna]
  (->> dna
       (map (fn [l]
              (let [result (get {"G" "C"
                                 "C" "G"
                                 "T" "A"
                                 "A" "U"} (str l))]
                (assert result)
                result)
              ))
       (reduce str "")))