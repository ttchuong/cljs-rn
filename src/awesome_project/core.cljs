(ns awesome-project.core
  (:require
   ["../hello" :as hello]
   ["react" :as r]
   ["react-native" :as rn]
   ["react-native-date-picker$default" :as dp]
   ["tailwind-rn" :refer [TailwindProvider useTailwind]]
   [awesome-project.platform :as p]
   [shadow.react-native :refer (render-root)]))


(defn hello-text []
  (let [tailwind (useTailwind)]
    (r/createElement rn/Text
                     #js {:style (tailwind "text-[50px] text-red-500")}
                     "Hello World")))

(defn main []
  (r/createElement
   TailwindProvider #js {:utilities (js/require "../tailwind/tailwind.json")}
   (r/createElement
    rn/View
    nil
    (r/createElement hello-text)
    (r/createElement dp (clj->js {:date (js/Date.)
                                  :onDateChange (fn [new-date]
                                                  (js/alert new-date))}))
    (r/createElement rn/Image (clj->js {:source (js/require "../assets/shadow-cljs.png")})))))

(defn start
  {:dev/after-load true}
  []
  (p/print-platform)
  (render-root "AwesomeProject" (r/createElement main)))

(defn init []
  (start))
