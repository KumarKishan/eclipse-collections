/*
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.test.map.mutable.sorted;

import java.util.Comparator;
import java.util.Iterator;

import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.test.bag.mutable.sorted.OrderedIterableNoIteratorTest;
import org.eclipse.junit.runners.Java8Runner;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNull;

@RunWith(Java8Runner.class)
public class TreeSortedMapNoIteratorTest implements MutableSortedMapIterableTestCase, OrderedIterableNoIteratorTest
{
    @Override
    public <T> MutableSortedMap<Object, T> newWith(T... elements)
    {
        int i = elements.length;
        MutableSortedMap<Object, T> result = new TreeSortedMapNoIterator<>(Comparators.reverseNaturalOrder());
        for (T each : elements)
        {
            assertNull(result.put(i, each));
            i--;
        }
        return result;
    }

    @Override
    public void Iterable_remove()
    {
        OrderedIterableNoIteratorTest.super.Iterable_remove();
    }

    public static class TreeSortedMapNoIterator<K, V> extends TreeSortedMap<K, V>
    {
        public TreeSortedMapNoIterator()
        {
            // For serialization
        }

        public TreeSortedMapNoIterator(Comparator<? super K> comparator)
        {
            super(comparator);
        }

        @Override
        public Iterator<V> iterator()
        {
            throw new AssertionError("No iteration patterns should delegate to iterator()");
        }
    }
}