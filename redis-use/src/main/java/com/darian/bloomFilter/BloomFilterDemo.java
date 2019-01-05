package com.darian.bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import javafx.scene.effect.Bloom;

import java.nio.charset.Charset;

public class BloomFilterDemo {
    public static void main(String[] args) {
        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(
                Funnels.stringFunnel(Charset.defaultCharset()),
                1000000, 0.0001);

        bloomFilter.put("darian");
        System.out.println(bloomFilter.mightContain("darian"));
    }
}
