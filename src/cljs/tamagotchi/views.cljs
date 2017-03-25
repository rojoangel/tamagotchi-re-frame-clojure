(ns tamagotchi.views
  (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [name (re-frame/subscribe [:name])
        hungriness (re-frame/subscribe [:hungriness])]
    (fn []
      [:div
       [:div "name: " @name]
       [:div "hungriness: " @hungriness]
       ])))
