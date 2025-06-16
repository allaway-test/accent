(ns accent.state-test
  (:require [clojure.test :refer :all]
            [accent.state :refer [set-api-key! u]]))

(deftest set-api-key-test
  (testing "Set OpenRouter API key"
    (set-api-key! "OpenRouter" "test-key")
    (is (= "test-key" (@u :orak)))
    (is (= "OpenRouter" (@u :model-provider))))
  
  (testing "Set OpenAI API key"
    (set-api-key! "OpenAI" "openai-key")
    (is (= "openai-key" (@u :oak)))
    (is (= "OpenAI" (@u :model-provider))))
  
  (testing "Set Anthropic API key"
    (set-api-key! "Anthropic" "anthropic-key")
    (is (= "anthropic-key" (@u :aak)))
    (is (= "Anthropic" (@u :model-provider)))))