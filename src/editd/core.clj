(ns editd.core
  (:use clojure.test))

;; naive recursive solution
;; returns min of delete char from str1, delete char from str2, and delete char from str1 & str2
(defn editd [str1 str2]
  (let [len1 (count str1)
        len2 (count str2)]
    (cond (zero? len1) len2
          (zero? len2) len1
          :else
          (let [price (if (= (first str1) (first str2)) 0 1)]
                (min (inc (editd (rest str1) str2))
                     (inc (editd str1 (rest str2)))
                     (+ price (editd (rest str1) (rest str2))))))))

(deftest test-editd
  (is (= 0 (editd "abcd" "abcd")))
  (is (= 1 (editd "abc" "abb")))
  (is (= 3 (editd "saturday" "sunday")))
  (is (= 3 (editd "kitten" "sitting"))))

(run-tests)
