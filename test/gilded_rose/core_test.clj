(ns gilded-rose.core-test
  (:require
          [clojure.test :refer :all]
          [gilded-rose.core :refer [item update-quality]]))

(deftest agedbrie
  (testing "aged brie"
    (is (= '({:quality 1 :name "Aged Brie" :sell-in 1}) (update-quality [(item "Aged Brie" 2 0)])))))
