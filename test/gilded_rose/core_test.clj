(ns gilded-rose.core-test
  (:require
          [clojure.test :refer :all]
          [gilded-rose.core :refer [item update-quality]]))

(deftest agedbrie
  (testing "aged brie"
    (is (= '({:quality 1 :name "Aged Brie" :sell-in 1}) (update-quality [(item "Aged Brie" 2 0)])))
    (is (= '({:quality 1 :name "Aged Brie" :sell-in 0}) (update-quality [(item "Aged Brie" 1 0)])))
    (is (= '({:quality 1 :name "Aged Brie" :sell-in -1}) (update-quality [(item "Aged Brie" 0 0)])))
    (is (= '({:quality 3 :name "Aged Brie" :sell-in 1}) (update-quality [(item "Aged Brie" 2 2)])))))

(deftest update-current-inv
  (let [inventory 
      [
        (item "+5 Dexterity Vest" 10 20)
        (item "Aged Brie" 2 0)
        (item "Elixir of the Mongoose" 5 7)
        (item "Sulfuras, Hand of Ragnaros" 0 80)
        (item "Backstage passes to a TAFKAL80ETC concert" 15 20)
      ]]
      (update-quality inventory)
  (testing "updating current inv"
    (is (= '(
         {:name "+5 Dexterity Vest", :sell-in 10, :quality 20}
         {:name "Aged Brie", :sell-in 2, :quality 0}
         {:name "Elixir of the Mongoose", :sell-in 5, :quality 7}
         {:name "Sulfuras, Hand of Ragnaros", :sell-in 0, :quality 80}
         {:name "Backstage passes to a TAFKAL80ETC concert", :sell-in 15, :quality 20})
          inventory)))))
