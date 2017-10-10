package cacheOfAnno;

import java.util.Collection;

import org.springframework.cache.support.AbstractCacheManager;

public class MyCacheManager extends AbstractCacheManager {
	private Collection<? extends MyCache> caches;

	/**
	 * Specify the collection of Cache instances to use for this CacheManager.
	 */
	public void setCaches(Collection<? extends MyCache> caches) {
		this.caches = caches;
	}

	@Override
	protected Collection<? extends MyCache> loadCaches() {
		return this.caches;
	}
}